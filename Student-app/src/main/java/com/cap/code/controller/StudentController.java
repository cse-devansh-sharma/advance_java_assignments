package com.cap.code.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cap.code.model.Student;
import com.cap.code.repository.StudentRepo;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    // GET all students from DB
    @GetMapping
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    // POST - save student to DB
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }
}