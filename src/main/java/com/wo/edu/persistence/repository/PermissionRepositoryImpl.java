package com.wo.edu.persistence.repository;

import com.wo.edu.domain.dto.PermissionDto;
import com.wo.edu.domain.repository.IPermissionDtoRepository;
import com.wo.edu.persistence.entity.role.Permission;
import com.wo.edu.persistence.mapper.IPermissionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PermissionRepositoryImpl implements IPermissionDtoRepository {
    private final IPermissionRepository permissionRepository;
    private final IPermissionMapper permissionMapper;

    @Override
    public List<PermissionDto> findPermissionsByActiveTrue() {
        List<Permission> permissions = permissionRepository.findPermissionsByActiveTrue();
        return permissionMapper.toPermissionsDto(permissions);
    }
}
