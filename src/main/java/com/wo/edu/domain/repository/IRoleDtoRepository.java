package com.wo.edu.domain.repository;

import com.wo.edu.domain.dto.RoleDto;

import java.util.List;
import java.util.Optional;

public interface IRoleDtoRepository {
    List<RoleDto> findRolesByActiveTrue();

    Optional<RoleDto> findById(Long id);
}
