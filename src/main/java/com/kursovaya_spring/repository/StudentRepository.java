package com.kursovaya_spring.repository;

import com.kursovaya_spring.model.Faculty;
import com.kursovaya_spring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(int from, int to);
}
