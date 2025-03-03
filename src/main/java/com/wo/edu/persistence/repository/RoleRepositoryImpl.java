package com.wo.edu.persistence.repository;

import com.wo.edu.domain.dto.RoleDto;
import com.wo.edu.domain.repository.IRoleDtoRepository;
import com.wo.edu.persistence.entity.role.Role;
import com.wo.edu.persistence.mapper.IRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RoleRepositoryImpl implements IRoleDtoRepository {
    private final IRoleRepository roleRepository;
    private final IRoleMapper roleMapper;

    @Override
    public List<RoleDto> findRolesByActiveTrue() {
        List<Role> roles = roleRepository.findRolesByActiveTrue();
        return roleMapper.toRolesDto(roles);
    }

    @Override
    public Optional<RoleDto> findById(Long id) {
        return roleRepository.findById(id).map(roleMapper::toRoleDto);
    }
}
