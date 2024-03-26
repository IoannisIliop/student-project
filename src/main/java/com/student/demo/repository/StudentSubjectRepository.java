package com.student.demo.repository;

import com.student.demo.student.domain.StudentSubject;
import com.student.demo.student.entity.StudentSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubjectEntity,Long> {

}
