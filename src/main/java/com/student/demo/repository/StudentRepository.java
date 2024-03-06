package com.student.demo.repository;

import com.student.demo.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository  extends JpaRepository <StudentEntity, Long>{
    Optional<StudentEntity> getStudentEntityById(long id);

}
