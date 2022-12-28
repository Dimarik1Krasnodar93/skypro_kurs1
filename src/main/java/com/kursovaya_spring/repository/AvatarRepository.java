package com.kursovaya_spring.repository;

import com.kursovaya_spring.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;

public interface AvatarRepository extends PagingAndSortingRepository<Avatar, Long> {
    Avatar findByStudent(Long student_id);
}
