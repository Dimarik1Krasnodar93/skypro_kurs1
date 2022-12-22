package controllers;

import com.kursovaya_spring.model.Faculty;
import com.kursovaya_spring.model.Student;
import com.kursovaya_spring.services.FacultyService;
import com.kursovaya_spring.services.StudentsService;
import io.swagger.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentsService studentsService;
    private final FacultyService facultyService;


    public StudentController(StudentsService studentsService, FacultyService facultyService) {
        this.studentsService = studentsService;
        this.facultyService = facultyService;
    }

    @GetMapping("/create")
    public ResponseEntity<Student> create(@RequestParam("name") String name, @RequestParam("age") int age,
                                 @RequestParam("faculty_id") Long faculty_id) {
        return ResponseEntity.ok(studentsService.create(new Student(name, age, facultyService.findById(faculty_id))));
    }

    @GetMapping("/findByAgeBetween")
    public Collection<Student> betweenAge(@RequestParam("from") int from, @RequestParam("to") int to) {
        return studentsService.findByAgeBetween(from, to);
    }

    @GetMapping("/findAll")
    public Collection<Student> getAll() {
        return studentsService.findAll();
    }
    @GetMapping("/getFaculty{id}")
    @Operation(summary = "ask faculty")
    public Faculty getFaculty(@PathVariable Long id) {
        return studentsService.findById(id).getFaculty();
    }

}
