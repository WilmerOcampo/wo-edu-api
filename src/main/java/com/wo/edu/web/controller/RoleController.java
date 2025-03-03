package com.wo.edu.web.controller;

import com.wo.edu.domain.dto.RoleDto;
import com.wo.edu.domain.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
@CrossOrigin
public class RoleController {
    private final IRoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<List<RoleDto>> findRolesByActiveTrue() {
        return new ResponseEntity<>(roleService.findRolesByActiveTrue(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoleDto> findRoleById(@PathVariable("id") Long id) {
        return roleService.findById(id)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
