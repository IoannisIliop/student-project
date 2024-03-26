package com.student.demo.config;

import com.student.demo.repository.StudentRepository;
import com.student.demo.repository.SubjectRepository;
import com.student.demo.student.entity.SubjectEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
public class SubjectsConfig {
//    @Bean(name = "subjectsCommandLineRunner")
//    CommandLineRunner commandLineRunner(SubjectRepository repository) {
//        return args -> {
//            SubjectEntity english = new SubjectEntity(
//                    null,
//                    "English"
//            );
//            SubjectEntity chemistry = new SubjectEntity(
//                    null,
//                    "Chemistry"
//            );
//            repository.saveAll(
//                    List.of(english,chemistry)
//            );
//
//
//        };
//
//    }
}
