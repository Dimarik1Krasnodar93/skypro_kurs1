package com.kursovaya_spring.repository;

import com.kursovaya_spring.model.Faculty;
import com.kursovaya_spring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(int from, int to);

    @Query(value="SELECT COUNT(DISTINCT id) FROM STUDENT")
    int getStudentsCount();

    @Query(value = "SELECT AVG(age) FROM STUDENT", nativeQuery = true)
    int getAverageAge();

    @Query(value = "SELECT *  FROM STUDENT st ORDER BY id LIMIT 5", nativeQuery = true)
    Collection<Student> getFiveStudents();
}
