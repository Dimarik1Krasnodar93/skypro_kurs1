package com.kursovaya_spring.services;

import com.kursovaya_spring.model.Question;
import com.kursovaya_spring.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository questionRepository;
    private Set<Question> questions = new HashSet<>();

    public JavaQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String strQuestion, String strAnswer) {
        Question question = new Question(strQuestion, strAnswer);
        questions.add(question);
        return question;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        return questions.remove(question) ? question : null;
    }

    @Override
    public Collection<Question> getAll() {
        return new CopyOnWriteArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random(questions.size() - 1);
        int iNextRandom = random.nextInt();
        int i = 0;
        for (Question question : questions) {
            if (i == iNextRandom) {
                return question;
            }
            i++;
        }
        return null;
    }
}
