package com.kursovaya_spring.services;

import com.kursovaya_spring.model.Faculty;
import com.kursovaya_spring.repository.FacultyRepository;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
    private FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty findByColorAndName(String color, String name) {
        return facultyRepository.findByColorAndName(color, name);
    }

    public Faculty creaate(String name, String color) {
        return facultyRepository.save(new Faculty(name, color));
    }

    public Faculty findById(Long id) {
        return facultyRepository.findById(id).orElseThrow();
    }
}
