package com.student.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.demo.student.entity.TeacherEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    Optional<TeacherEntity> getTeacherEntityById(long id);


}
