package com.kursovaya_spring.services;

import com.kursovaya_spring.model.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}
