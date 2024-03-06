package com.student.demo.controller;

import com.student.demo.service.StudentService;
import com.student.demo.student.domain.Student;
import com.student.demo.student.domain.StudentUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable Long id,
                                     @RequestBody StudentUpdateRequest request) {
        //TODO: Fill in the flow
        request.setId(id);
        return studentService.updateStudentById(request);
    }

}
