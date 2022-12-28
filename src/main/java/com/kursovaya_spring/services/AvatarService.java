package com.kursovaya_spring.services;

import com.kursovaya_spring.model.Avatar;
import com.kursovaya_spring.model.Student;
import com.kursovaya_spring.repository.AvatarRepository;
import com.kursovaya_spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
public class AvatarService {
    private AvatarRepository avatarRepository;
    private StudentRepository studentRepository;

    @Value("${path.to.avatars.folder}")
    private String avatarsDir;

    public AvatarService(AvatarRepository avatarRepository, StudentRepository studentRepository) {
        this.avatarRepository = avatarRepository;
        this.studentRepository = studentRepository;
    }

    public void uploadFile(Long studentId, MultipartFile file) throws IOException {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("Did not find student"));
        Path filePath = Path.of(avatarsDir, student + "." + getExtensions(file.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);
        try (
                InputStream inputStream = file.getInputStream();
                OutputStream outputStream = Files.newOutputStream(filePath, CREATE_NEW);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                ) {
            bufferedInputStream.transferTo(bufferedOutputStream);
        }
        Avatar avatar = findAvatar(studentId);
        avatar.setStudent(studentRepository.findById(studentId).orElseThrow());
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(file.getSize());
        avatar.setMediaType(file.getContentType());
        avatar.setData(file.getBytes());
        avatarRepository.save(avatar);
        avatar.setData(file.getBytes());
    }

    public Avatar findAvatar(Long id) {
        return avatarRepository.findById(id).orElse(new Avatar());
    }

    public void downloadFile(Long id, HttpServletResponse httpResponse) {
        Avatar avatar = avatarRepository.findById(id).orElseThrow();
        Path path = Path.of(avatar.getFilePath());
        try (InputStream inputStream = Files.newInputStream(path);
            OutputStream outputStream = httpResponse.getOutputStream()
        ) {
            httpResponse.setContentType(avatar.getMediaType());
            httpResponse.setContentLength((int)avatar.getFileSize());
            inputStream.transferTo(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Iterable<Avatar> findAll() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        return avatarRepository.findAll();
    }

    private Object getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }


}
