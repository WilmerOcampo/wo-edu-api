package com.wo.edu.persistence.repository;

import com.wo.edu.domain.dto.CourseDto;
import com.wo.edu.domain.repository.ICourseDtoRepository;
import com.wo.edu.persistence.entity.course.Category;
import com.wo.edu.persistence.entity.course.Course;
import com.wo.edu.persistence.entity.course.Teacher;
import com.wo.edu.persistence.mapper.ICourseMapper;
import com.wo.edu.persistence.util.EntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CourseRepositoryImpl implements ICourseDtoRepository {
    private final ICourseRepository courseRepository;
    private final ITeacherRepository teacherRepository;
    private final ICourseMapper courseMapper;

    @Override
    public List<CourseDto> findCoursesByActiveTrue() {
        List<Course> courses = courseRepository.findCoursesByActiveTrue();
        return courseMapper.toCoursesDto(courses);
    }

    @Override
    public List<CourseDto> findCoursesByTeacherId(Long teacherId) {
        List<Course> courses = courseRepository.findCoursesByTeacherId(teacherId);
        return courseMapper.toCoursesDto(courses);
    }

    @Override
    public Optional<CourseDto> findById(Long id) {
        return courseRepository.findById(id).map(courseMapper::toCourseDto);
    }

    @Override
    @Transactional
    public CourseDto save(CourseDto courseDto) {
        Course course = courseMapper.toCourse(courseDto);

        Teacher teacher = teacherRepository.findById(courseDto.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        course.setTeacher(teacher);
        EntityConverter.setEntitiesFromIds(course::setCategories, courseDto.getCategoryIds(), Category::new);

        return courseMapper.toCourseDto(courseRepository.save(course));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
