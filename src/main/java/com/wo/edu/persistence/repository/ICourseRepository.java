package com.wo.edu.persistence.repository;

import com.wo.edu.persistence.entity.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCoursesByTeacherId(Long teacherId);

    List<Course> findCoursesByActiveTrue();
}
