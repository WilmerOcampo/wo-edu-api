package com.wo.edu.web.security;

import com.wo.edu.domain.dto.*;
import com.wo.edu.domain.response.RegisterResponse;
import com.wo.edu.domain.service.IProfessionService;
import com.wo.edu.domain.service.IRoleService;
import com.wo.edu.domain.service.IUserService;
import com.wo.edu.web.security.payload.LoginRequest;
import com.wo.edu.web.security.payload.LoginResponse;
import com.wo.edu.web.security.service.IAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
    private final IUserService userService;
    private final IAuthService authService;
    private final IRoleService roleService;
    private final IProfessionService professionService;

    @GetMapping("/role/all")
    public ResponseEntity<List<RoleDto>> findRolesByActiveTrue() {
        return new ResponseEntity<>(roleService.findRolesByActiveTrue(), HttpStatus.OK);
    }

    @GetMapping("/profession/all")
    public ResponseEntity<List<ProfessionDto>> findProfessionsByActiveTrue() {
        return new ResponseEntity<>(professionService.findProfessionsByActiveTrue(), HttpStatus.OK);
    }

    @GetMapping("/professions/teacher/{id}")
    public ResponseEntity<List<ProfessionDto>> findProfessionsByTeacherId(@PathVariable("id") Long teacherId) {
        return new ResponseEntity<>(professionService.findProfessionsByTeacherId(teacherId), HttpStatus.OK);
    }

    @PostMapping("/user/save")
    public ResponseEntity<RegisterResponse> saveUser(@RequestBody SaveUser userDto) {
        if (userDto.getId() == null) {
            return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.OK);
        }
    }

    @PostMapping("/teacher/save")
    public ResponseEntity<RegisterResponse> saveTeacher(@RequestBody SaveTeacher userDto) {
        if (userDto.getId() == null) {
            return new ResponseEntity<>(userService.saveTeacher(userDto), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(userService.saveTeacher(userDto), HttpStatus.OK);
        }
    }

    @PostMapping("/log-in")
    public ResponseEntity<LoginResponse> logIn(@RequestBody @Valid LoginRequest userRequest) {
        return new ResponseEntity<>(this.authService.login(userRequest), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id) {
        return userService.findById(id)
                .map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
