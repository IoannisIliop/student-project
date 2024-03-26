package com.student.demo.student.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TeacherUpdateRequest {
    private long id;
    private String name;
    private String email;
    private LocalDate dod;
    private String lesson;
}
