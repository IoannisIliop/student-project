package com.student.demo.controller;

import com.student.demo.service.SubjectService;
import com.student.demo.student.domain.AddSubjectRequest;
import com.student.demo.student.domain.Subject;
import com.student.demo.student.domain.UpdateSubjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/Subject")
public class SubjectsController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectsController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> getSubjects() {
        return subjectService.getSubject();
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }

    @PostMapping
    public Subject addSubject(@RequestBody AddSubjectRequest request) {
        return subjectService.addSubject(request);
    }

    @PutMapping("/{id}")
    public Subject updateSubjectById(@PathVariable Long id,
                                     @RequestBody UpdateSubjectRequest request) {
        request.setId(id);
        return subjectService.updateSubjectById(request);
    }

}
