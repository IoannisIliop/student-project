package com.student.demo.student.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTeacherRequest {
    private String name;
    private String email;
    private LocalDate dod;
    private String lesson;
}
