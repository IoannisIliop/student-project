package com.student.demo.service;


import com.student.demo.repository.StudentRepository;
import com.student.demo.student.domain.Student;
import com.student.demo.student.domain.StudentUpdateRequest;
import com.student.demo.student.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
//        List<StudentEntity> students = studentRepository.findAll();
//        List<Student> studentsDomain = new ArrayList<>();
//        for (StudentEntity student : students) {
//            studentsDomain.add(
//                    Student.builder()
//                            .id(student.getId())
//                            .email(student.getEmail())
//                            .name(student.getName())
//                            .dod(student.getDod())
//                            .build()
//            );
//        }
//        return studentsDomain;

        return studentRepository.findAll()
                .stream()
                .map(studentEntity ->
                        Student.builder()
                                .id(studentEntity.getId())
                                .email(studentEntity.getEmail())
                                .name(studentEntity.getName())
                                .dod(studentEntity.getDod())
                                .build()
                )
                .collect(Collectors.toList());
    }


    public Student getStudentById(long id) {
        Optional<StudentEntity> optionalStudent = studentRepository.getStudentEntityById(id);

        return optionalStudent.map(studentEntity -> Student.builder()
                .id(studentEntity.getId())
                .email(studentEntity.getEmail())
                .name(studentEntity.getName())
                .dod(studentEntity.getDod())
                .build()).orElseThrow(() -> new RuntimeException("Student with id: " + id + " not found"));
    }

    public Student updateStudentById(StudentUpdateRequest request) {
        Student student = getStudentById(request.getId());
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        //TODO: Map the domain back to entity
        StudentEntity studentEntity = StudentEntity.builder().
                id(student.getId())
                .email(student.getEmail())
                .name(student.getName())
                .dod(student.getDod())
                .build();

        //TODO: Save entity
        StudentEntity updatedStudentEntity = studentRepository.save(studentEntity);
        Student updatedStudent = Student.builder().
                id(updatedStudentEntity.getId())
                .email(updatedStudentEntity.getEmail())
                .name(updatedStudentEntity.getName())
                .dod(updatedStudentEntity.getDod())
                .build();
        return updatedStudent;
    }

}
