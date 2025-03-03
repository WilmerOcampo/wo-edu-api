package com.wo.edu.domain.repository;

import com.wo.edu.domain.dto.CourseDto;

import java.util.List;
import java.util.Optional;

public interface ICourseDtoRepository {
    List<CourseDto> findCoursesByTeacherId(Long userId);

    List<CourseDto> findCoursesByActiveTrue();

    Optional<CourseDto> findById(Long id);

    CourseDto save(CourseDto courseDto);

    void deleteById(Long id);
}
