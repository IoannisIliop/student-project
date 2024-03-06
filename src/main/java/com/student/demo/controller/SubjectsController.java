package com.student.demo.controller;

import com.student.demo.service.SubjectService;
import com.student.demo.student.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/Subject")
public class SubjectsController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectsController (SubjectService subjectService) {this.subjectService = subjectService;}

    @GetMapping
    public List<Subject> getSubjects() {return SubjectService.getSubjects();}


}
