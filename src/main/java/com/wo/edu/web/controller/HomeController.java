package com.wo.edu.web.controller;

import com.wo.edu.domain.dto.ContactDto;
import com.wo.edu.domain.dto.CourseDto;
import com.wo.edu.domain.dto.UserDto;
import com.wo.edu.domain.service.IContactService;
import com.wo.edu.domain.service.ICourseService;
import com.wo.edu.domain.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home")
@RequiredArgsConstructor
@CrossOrigin
public class HomeController {
    private final IUserService userService;
    private final ICourseService courseService;
    private final IContactService contactService;

    @GetMapping("/teacher/all")
    public ResponseEntity<List<UserDto>> findAllTeachers() {
        return new ResponseEntity<>(userService.findAllTeachers(), HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDto>> findCoursesByActiveTrue() {
        return new ResponseEntity<>(courseService.findCoursesByActiveTrue(), HttpStatus.OK);
    }

    @PostMapping("/contact/save")
    public ResponseEntity<ContactDto> save(@RequestBody ContactDto contactDto) {
        return new ResponseEntity<>(contactService.save(contactDto), HttpStatus.OK);
    }


    /**/
    @GetMapping("/user/all")
    public ResponseEntity<List<UserDto>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }
}
