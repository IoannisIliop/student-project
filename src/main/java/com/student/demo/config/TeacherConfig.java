package com.student.demo.config;

import com.student.demo.repository.TeacherRepository;
import com.student.demo.student.entity.TeacherEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

public class TeacherConfig {
    @Bean(name = "teacherCommandLineRunner")
    CommandLineRunner commandLineRunner(TeacherRepository repository) {
        return args -> {
            TeacherEntity alex = new TeacherEntity(
                    1,
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(1980, 4, 12),
                    "English"
            );
            TeacherEntity panos = new TeacherEntity(
                    null,
                    "Panos",
                    "panos@gmail.com",
                    LocalDate.of(1995, 4, 15),
                    "Chemistry"
            );
            repository.saveAll(
                    List.of(alex, panos)
            );


        };

    }
}
