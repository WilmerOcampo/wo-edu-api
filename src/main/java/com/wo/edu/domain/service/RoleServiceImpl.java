package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.RoleDto;
import com.wo.edu.domain.repository.IRoleDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {
    private final IRoleDtoRepository roleDtoRepository;

    @Override
    public List<RoleDto> findRolesByActiveTrue() {
        return roleDtoRepository.findRolesByActiveTrue();
    }

    @Override
    public Optional<RoleDto> findById(Long id) {
        return roleDtoRepository.findById(id);
    }
}
