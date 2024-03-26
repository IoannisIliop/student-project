package com.student.demo.service;

import com.student.demo.repository.SubjectRepository;
import com.student.demo.student.domain.AddSubjectRequest;
import com.student.demo.student.domain.Student;
import com.student.demo.student.domain.Subject;
import com.student.demo.student.domain.UpdateSubjectRequest;
import com.student.demo.student.entity.StudentEntity;
import com.student.demo.student.entity.SubjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;


    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getSubject() {
        return subjectRepository.findAll()
                .stream()
                .map(subjectEntity ->
                        Subject.builder()
                                .id(subjectEntity.getId())
                                .name(subjectEntity.getName())
                                .build()
                )
                .collect(Collectors.toList());
    }

    public Subject getSubjectById(Long id) {
        Optional<SubjectEntity> optionalSubject = subjectRepository.getSubjectEntityById(id);

        return optionalSubject.map(subjectEntity -> Subject.builder()
                .id(subjectEntity.getId())
                .name(subjectEntity.getName())
                .build()).orElseThrow(() -> new RuntimeException("Subject with id: " + id + " not found"));
    }

    public Subject addSubject(AddSubjectRequest request) {
        Subject subject = Subject.builder()
                .name(request.getName())
                .build();

        SubjectEntity subjectEntity = SubjectEntity.builder()
                .name(subject.getName())
                .build();

        SubjectEntity addedSubjectEntity = subjectRepository.save(subjectEntity);
        Subject addedSubject = Subject.builder()
                .id(addedSubjectEntity.getId())
                .name(addedSubjectEntity.getName())
                .build();

        return addedSubject;
    }

    public Subject updateSubjectById (UpdateSubjectRequest request) {
        Subject subject = getSubjectById(request.getId());
        subject.setName(request.getName());

        SubjectEntity subjectEntity = SubjectEntity.builder()
                .id(subject.getId())
                .name(subject.getName())
                .build();

       SubjectEntity updatedSubjectEntity = subjectRepository.save(subjectEntity);
        Subject updatedSubject = Subject.builder()
                .id(updatedSubjectEntity.getId())
                .name(updatedSubjectEntity.getName())
                .build();
        return updatedSubject;
    }

}