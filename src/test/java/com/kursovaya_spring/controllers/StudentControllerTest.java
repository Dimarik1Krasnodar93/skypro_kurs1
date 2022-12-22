package com.kursovaya_spring.controllers;


import com.kursovaya_spring.model.Student;
import controllers.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    public int port;

    @Test
    public void testCreate() throws Exception {

        String name = "Ivan";
        int age = 19;
        assertThat(this.restTemplate.getForObject("http://localhost:" + port
                        + "/students/create?name=" + name + "&age=" + age, ResponseEntity.class).getBody()
                .equals(new Student(name, age)));
    }


}