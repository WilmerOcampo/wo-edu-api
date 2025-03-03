package com.wo.edu.persistence.mapper;

import com.wo.edu.domain.dto.PermissionDto;
import com.wo.edu.persistence.entity.role.Permission;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPermissionMapper {
    @Mapping(target = "name", source = "EPermission")
    PermissionDto toPermissionDto(Permission permission);

    List<PermissionDto> toPermissionsDto(List<Permission> permissions);

    @InheritInverseConfiguration
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Permission toPermission(PermissionDto permissionDto);
}
