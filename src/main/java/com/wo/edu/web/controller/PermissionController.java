package com.wo.edu.web.controller;

import com.wo.edu.domain.dto.PermissionDto;
import com.wo.edu.domain.service.IPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/permission")
@RequiredArgsConstructor
@CrossOrigin
public class PermissionController {
    private final IPermissionService permissionService;

    @GetMapping("/all")
    public ResponseEntity<List<PermissionDto>> findPermissionsByActiveTrue() {
        return new ResponseEntity<>(permissionService.findPermissionsByActiveTrue(), HttpStatus.OK);
    }
}
