package com.student.demo.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubject {
    private Long id;
    private Long studentId;
    private Long subjectId;
}
