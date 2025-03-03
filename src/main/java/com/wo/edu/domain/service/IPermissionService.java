package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.PermissionDto;

import java.util.List;

public interface IPermissionService {
    List<PermissionDto> findPermissionsByActiveTrue();
}
