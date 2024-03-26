package com.student.demo.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Teacher {
    private long id;
    private String name;
    private String email;
    private LocalDate dod;
    private String lesson;
}
