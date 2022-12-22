package controllers;

import com.kursovaya_spring.model.Question;
import com.kursovaya_spring.services.JavaQuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {
    private final JavaQuestionService javaQuestionService;

    public JavaController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("questionText") String questionText, @RequestParam("answerText") String answerText) {
        return javaQuestionService.add(questionText, answerText);
    }

    @PostMapping("/add")
    public Question add(@RequestBody Question question) {
        return javaQuestionService.add(question);
    }

    @PostMapping("/remove")
    public Question remove(@RequestBody Question question) {
        return javaQuestionService.remove(question);
    }

    @GetMapping("/getAll")
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

    @GetMapping("/getRandomQuestion")
    public Question getRandomQuestion() {
        return javaQuestionService.getRandomQuestion();
    }

}
