package com.wo.edu.persistence.mapper;

import com.wo.edu.domain.dto.RoleDto;
import com.wo.edu.persistence.entity.role.Role;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRoleMapper {
    @Mapping(target = "name", source = "ERole")
    RoleDto toRoleDto(Role role);

    List<RoleDto> toRolesDto(List<Role> roles);

    @InheritInverseConfiguration
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleDto roleDto);
}
