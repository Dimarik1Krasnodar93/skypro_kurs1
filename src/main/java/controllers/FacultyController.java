package controllers;

import com.kursovaya_spring.model.Faculty;
import com.kursovaya_spring.repository.FacultyRepository;
import com.kursovaya_spring.services.FacultyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/findByColorAndName")
    public Faculty findByColorAndName(@RequestParam("color") String color, @RequestParam("name") String name) {
        return facultyService.findByColorAndName(color, name);
    }

    @GetMapping("/create")
    public Faculty create(@RequestParam("name") String name, @RequestParam("color") String color) {
        return facultyService.creaate(name, color);
    }
}
