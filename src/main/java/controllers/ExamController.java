package controllers;

import com.kursovaya_spring.exceptions.IllegalAmountException;
import com.kursovaya_spring.model.Question;
import com.kursovaya_spring.services.ExaminerService;
import com.kursovaya_spring.services.ExaminerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/exam/controller")
public class ExamController {
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/getQuestions{amount}")
    public Set<Question> getQuestions(int amount) {

        return examinerService.getQuestions(amount);
    }

    @ExceptionHandler(value = IllegalAmountException.class)
    public ResponseEntity<String> illegalAmountExceptionHandler(IllegalAmountException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
