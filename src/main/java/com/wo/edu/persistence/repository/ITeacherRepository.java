package com.wo.edu.persistence.repository;

import com.wo.edu.persistence.entity.course.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findTeachersByActiveTrue();
}
