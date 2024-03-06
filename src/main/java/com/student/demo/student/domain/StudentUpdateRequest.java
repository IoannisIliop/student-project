package com.student.demo.student.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentUpdateRequest {
    private Long id;
    private String name;
    private String email;
}
