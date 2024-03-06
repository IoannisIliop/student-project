package com.student.demo.config;

import com.student.demo.repository.StudentRepository;
import com.student.demo.student.entity.StudentEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

//@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            StudentEntity alex = new StudentEntity(
                    null,
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2000, JANUARY, 3)

            );
            StudentEntity panos = StudentEntity.builder()
                    .name("Panos")
                    .email("Panos@gmail.com")
                    .dod(LocalDate.of(1999, JANUARY, 3))
                    .build();

            repository.saveAll(
                    List.of(alex, panos)
            );

        };
    }
}
