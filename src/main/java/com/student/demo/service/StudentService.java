package com.student.demo.service;


import com.student.demo.repository.StudentRepository;
import com.student.demo.repository.StudentSubjectRepository;
import com.student.demo.student.domain.*;
import com.student.demo.student.entity.StudentEntity;
import com.student.demo.student.entity.StudentSubjectEntity;
import com.student.demo.student.entity.SubjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentSubjectRepository studentSubjectRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentSubjectRepository studentSubjectRepository) {
        this.studentRepository = studentRepository;
        this.studentSubjectRepository = studentSubjectRepository;
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
                                .subjects(
                                        studentEntity.getSubjects().stream()
                                                .map(entity -> {return mapSubject(entity);})
                                                .collect(Collectors.toList())
                                )
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
        Student updatedStudent = Student.builder()
                .id(updatedStudentEntity.getId())
                .email(updatedStudentEntity.getEmail())
                .name(updatedStudentEntity.getName())
                .dod(updatedStudentEntity.getDod())
                .build();
        return updatedStudent;
    }

    public Student addStudent(AddStudentRequest request) {
        Student student = Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .dod(request.getDod())
                .build();

        StudentEntity studentEntity = StudentEntity.builder()
                .name(student.getName())
                .email(student.getEmail())
                .dod(student.getDod())
                .build();

        StudentEntity studentSavedEntity = studentRepository.save(studentEntity);
        Student studentSaved = Student.builder()
                .id(studentSavedEntity.getId())
                .name(studentSavedEntity.getName())
                .email(studentSavedEntity.getEmail())
                .dod(studentSavedEntity.getDod())
                .build();

        return studentSaved;

    }

    public void enrollStudent(EnrollStudentRequest request) {
        StudentSubject studentSubject = StudentSubject.builder()
                .studentId(request.getStudentId())
                .subjectId(request.getSubjectId())
                .build();

        StudentSubjectEntity studentSubjectEntity = StudentSubjectEntity.builder()
                .studentId(studentSubject.getStudentId())
                .subjectId(studentSubject.getSubjectId())
                .build();

         studentSubjectRepository.save(studentSubjectEntity);

    }

    private Subject mapSubject(SubjectEntity entity) {
        return Subject.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
