package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.ProfessionDto;
import com.wo.edu.domain.repository.IProfessionDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionServiceImpl implements IProfessionService {
    private final IProfessionDtoRepository professionDtoRepository;

    @Override
    public List<ProfessionDto> findProfessionsByActiveTrue() {
        return professionDtoRepository.findProfessionsByActiveTrue();
    }

    @Override
    public List<ProfessionDto> findProfessionsByTeacherId(Long id) {
        return professionDtoRepository.findProfessionsByTeacherId(id);
    }
}
