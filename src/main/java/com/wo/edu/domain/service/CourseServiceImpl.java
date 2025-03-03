package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.CourseDto;
import com.wo.edu.domain.repository.ICourseDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {
    private final ICourseDtoRepository courseDtoRepository;

    @Override
    public List<CourseDto> findCoursesByActiveTrue() {
        return courseDtoRepository.findCoursesByActiveTrue();
    }

    @Override
    public List<CourseDto> findCoursesByTeacherId(Long userId) {
        return courseDtoRepository.findCoursesByTeacherId(userId);
    }

    @Override
    public Optional<CourseDto> findById(Long id) {
        return courseDtoRepository.findById(id);
    }

    @Override
    public CourseDto save(CourseDto courseDto) {
        return courseDtoRepository.save(courseDto);
    }

    @Override
    public Boolean deleteById(Long id) {
        return findById(id).map(c -> {
            courseDtoRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
