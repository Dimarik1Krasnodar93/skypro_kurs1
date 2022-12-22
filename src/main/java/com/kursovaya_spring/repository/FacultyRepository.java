package com.kursovaya_spring.repository;

import com.kursovaya_spring.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByColorAndName(String color, String name);
}
