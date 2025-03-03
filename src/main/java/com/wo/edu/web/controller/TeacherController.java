package com.wo.edu.web.controller;

import com.wo.edu.domain.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
@CrossOrigin
public class TeacherController {
    private final IUserService userService;

    /*@GetMapping("/all")
    public ResponseEntity<List<TeacherDto>> findAll() {
        return new ResponseEntity<>(userService.findAllTeachers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> findById(@PathVariable("id") Long id) {
        return userService.findTeacherById(id)
                .map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<RegisterResponse> save(@RequestBody TeacherDto teacherDto) {
        if (teacherDto.getId() == null) {
            return new ResponseEntity<>(userService.saveTeacher(teacherDto), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(userService.saveTeacher(teacherDto), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        if (userService.deleteTeacherById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/
}
