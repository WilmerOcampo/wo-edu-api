package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.CourseDto;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    List<CourseDto> findCoursesByTeacherId(Long userId);

    List<CourseDto> findCoursesByActiveTrue();

    Optional<CourseDto> findById(Long id);

    CourseDto save(CourseDto courseDto);

    Boolean deleteById(Long id);
}
