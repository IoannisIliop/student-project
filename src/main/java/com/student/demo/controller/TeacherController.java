package com.student.demo.controller;

import com.student.demo.service.TeacherService;
import com.student.demo.student.domain.AddTeacherRequest;
import com.student.demo.student.domain.Teacher;
import com.student.demo.student.domain.TeacherUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeacher() {
        return teacherService.getTeacher();
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody AddTeacherRequest request) {
        return teacherService.addTeacher(request);
    }

    @GetMapping(path = {"/{id}"})
    public Teacher getTeacherById(@PathVariable long id) {
        return teacherService.getTeacherById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Teacher updateTeacherById(@PathVariable Long id,
                                     @RequestBody TeacherUpdateRequest request) {
        request.setId(id);
        return teacherService.updatedTeacher(request);
    }
}
