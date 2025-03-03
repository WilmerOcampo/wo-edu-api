package com.wo.edu.web.controller;

import com.wo.edu.domain.dto.CategoryDto;
import com.wo.edu.domain.dto.CourseDto;
import com.wo.edu.domain.service.ICategoryService;
import com.wo.edu.domain.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
@CrossOrigin
public class CourseController {
    private final ICourseService courseService;
    private final ICategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<CourseDto>> findAll() {
        return new ResponseEntity<>(courseService.findCoursesByActiveTrue(), HttpStatus.OK);
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<List<CourseDto>> findCoursesByTeacherId(@PathVariable("id") Long teacherId) {
        return new ResponseEntity<>(courseService.findCoursesByTeacherId(teacherId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> findById(@PathVariable("id") Long id) {
        return courseService.findById(id)
                .map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<CourseDto> save(@RequestBody CourseDto courseDto) {
        return new ResponseEntity<>(courseService.save(courseDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        if (courseService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/category/all")
    public ResponseEntity<List<CategoryDto>> findCategoriesByActiveTrue() {
        return new ResponseEntity<>(categoryService.findCategoriesByActiveTrue(), HttpStatus.OK);
    }
}
