package com.kursovaya_spring.services;

import com.kursovaya_spring.exceptions.IllegalAmountException;
import com.kursovaya_spring.model.Question;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size()) {
            throw new IllegalAmountException("Amount is more than collection size");
        }
        Set<Question> rslt = new ConcurrentSkipListSet<>();
        while (rslt.size() < amount) {
            rslt.add(javaQuestionService.getRandomQuestion());
        }
        return rslt;
    }
}
