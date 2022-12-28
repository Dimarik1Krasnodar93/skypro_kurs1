package com.kursovaya_spring.services;

import com.kursovaya_spring.model.Faculty;
import com.kursovaya_spring.model.Student;
import com.kursovaya_spring.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentsService {
    StudentRepository studentRepository;

    public StudentsService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Collection<Student> findByAgeBetween(int from, int to) {

        return studentRepository.findByAgeBetween(from, to);
    }

    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student create(Student student) {
        return studentRepository.save(student);
    }


    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    public int getStudentsCount() {
        return studentRepository.getStudentsCount();
    }

    public int getAverageAge() {
        return studentRepository.getAverageAge();
    }

    public Collection<Student> getFiveStudents() {
        return studentRepository.getFiveStudents();
    }

}
