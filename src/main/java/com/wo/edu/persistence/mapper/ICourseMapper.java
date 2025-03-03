package com.wo.edu.persistence.mapper;

import com.wo.edu.domain.dto.CourseDto;
import com.wo.edu.persistence.entity.course.Course;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICourseMapper {
    @Mapping(target = "teacherId", ignore = true)
    @Mapping(target = "categoryIds", ignore = true)
    CourseDto toCourseDto(Course course);

    List<CourseDto> toCoursesDto(List<Course> courses);

    @InheritInverseConfiguration
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "topics", ignore = true)
    @Mapping(target = "teacher", ignore = true)
    @Mapping(target = "categories", ignore = true)
    Course toCourse(CourseDto courseDto);
}
