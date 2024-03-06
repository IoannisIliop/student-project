package com.student.demo.config;

import com.student.demo.repository.StudentRepository;
import com.student.demo.student.entity.SubjectEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class SubjectsConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            SubjectEntity english = new SubjectEntity(
                     null,
                     "English"
            );
        };
    }
}
