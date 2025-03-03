package com.wo.edu.web.controller;

import com.wo.edu.domain.dto.UserDto;
import com.wo.edu.domain.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final IUserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        if (userService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
