package com.student.demo.service;

import com.student.demo.repository.TeacherRepository;
import com.student.demo.student.domain.AddTeacherRequest;
import com.student.demo.student.domain.Student;
import com.student.demo.student.domain.Teacher;
import com.student.demo.student.domain.TeacherUpdateRequest;
import com.student.demo.student.entity.StudentEntity;
import com.student.demo.student.entity.TeacherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher addTeacher(AddTeacherRequest request) {
        Teacher teacher = Teacher.builder()
                .email(request.getEmail())
                .name(request.getName())
                .dod(request.getDod())
                .lesson(request.getLesson())
                .build();

        TeacherEntity teacherEntity = TeacherEntity.builder()
                .email(teacher.getEmail())
                .name(teacher.getName())
                .dod(teacher.getDod())
                .lesson(teacher.getLesson())
                .build();

        TeacherEntity savedTeacherEntity = teacherRepository.save(teacherEntity);

        return Teacher.builder()
                .id(savedTeacherEntity.getId())
                .lesson(savedTeacherEntity.getLesson())
                .dod(savedTeacherEntity.getDod())
                .email(savedTeacherEntity.getEmail())
                .name(savedTeacherEntity.getName())
                .build();
    }

    public List<Teacher> getTeacher() {
        return teacherRepository.findAll()
                .stream()
                .map(teacherEntity ->
                        Teacher.builder()
                                .id(teacherEntity.getId())
                                .email(teacherEntity.getName())
                                .name(teacherEntity.getEmail())
                                .dod(teacherEntity.getDod())
                                .lesson(teacherEntity.getLesson())
                                .build()
                )
                .collect(Collectors.toList());
    }

    public Teacher getTeacherById(long id) {
        Optional<TeacherEntity> optionalTeacher = teacherRepository.getTeacherEntityById(id);
        return optionalTeacher.map(teacherEntity ->  Teacher.builder()
                .id(teacherEntity.getId())
                .name(teacherEntity.getName())
                .email(teacherEntity.getEmail())
                .dod(teacherEntity.getDod())
                .lesson(teacherEntity.getLesson())
                .build()).orElseThrow(() -> new RuntimeException("Teacher with id: " + id + " not found"));
    }

    public Teacher updatedTeacher(TeacherUpdateRequest request) {
       Teacher teacher = getTeacherById(request.getId());
        teacher.setName(request.getName());
        teacher.setEmail(request.getEmail());
        teacher.setDod(request.getDod());
        teacher.setLesson(request.getLesson());

        TeacherEntity teacherEntity = TeacherEntity.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .email(teacher.getEmail())
                .dod(teacher.getDod())
                .lesson(teacher.getLesson())
                .build();

        TeacherEntity updatedTeacherEntity = teacherRepository.save(teacherEntity);
        Teacher updatedTeacher = Teacher.builder()
                .id(updatedTeacherEntity.getId())
                .name(updatedTeacherEntity.getName())
                .email(updatedTeacherEntity.getEmail())
                .dod(updatedTeacherEntity.getDod())
                .lesson(updatedTeacherEntity.getLesson())
                .build();

        return updatedTeacher;
    }
}



