package com.kursovaya_spring.repository;

import com.kursovaya_spring.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Avatar findByStudent(Long student_id);
}
