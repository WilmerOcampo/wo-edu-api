package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.PermissionDto;
import com.wo.edu.domain.repository.IPermissionDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements IPermissionService {
    private final IPermissionDtoRepository permissionDtoRepository;

    @Override
    public List<PermissionDto> findPermissionsByActiveTrue() {
        return permissionDtoRepository.findPermissionsByActiveTrue();
    }
}
