package com.student.demo.service;

import com.student.demo.repository.SubjectRepository;
import com.student.demo.student.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .map(studentEntity ->
                        Subject.builder()
                                .id(subjectEntity.getId())
                                .name(subjectEntity.getName())
                                .build()
                )
                .collect(Collectors.toList());
    }

}



 }
