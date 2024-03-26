package com.student.demo.student.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollStudentRequest {
    private Long studentId;
    private Long subjectId;
}
