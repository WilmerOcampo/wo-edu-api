package com.wo.edu.domain.repository;

import com.wo.edu.domain.dto.PermissionDto;

import java.util.List;

public interface IPermissionDtoRepository {
    List<PermissionDto> findPermissionsByActiveTrue();
}
