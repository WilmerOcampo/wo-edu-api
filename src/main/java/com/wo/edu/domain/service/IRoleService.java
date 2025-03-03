package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.RoleDto;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<RoleDto> findRolesByActiveTrue();

    Optional<RoleDto> findById(Long id);
}
