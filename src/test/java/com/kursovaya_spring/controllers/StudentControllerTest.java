package com.kursovaya_spring.controllers;


import com.kursovaya_spring.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private StudentController studentController;
    @LocalServerPort
    public int port;

    @Test
    public void testCreate() throws Exception {

        String name = "Ivan";
        int age = 19;
        int facultyId = 1;
        assertThat(this.restTemplate.getForObject("http://localhost:" + port
                        + "/students/create?name=" + name + "&age=" + age + "&faculty_id=" + facultyId, Student.class)
                .equals(new Student(name, age)));
    }

    @Test
    public void testUserController() {
        assertThat(studentController).isNotNull();
    }

    @Test
    public void testFindByAgeBetween() {
        int from = 5;
        int to = 54;
        String url = "http://localhost:" + port + "/students/findByAgeBetween?from=" + from + "&to=" + to;
        String res2 = this.restTemplate.getForObject(url, String.class);
        assertThat(this.restTemplate.getForObject(url, String.class)).isNotNull();
    }



}