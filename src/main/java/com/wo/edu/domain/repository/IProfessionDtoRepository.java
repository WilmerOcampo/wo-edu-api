package com.wo.edu.domain.repository;

import com.wo.edu.domain.dto.ProfessionDto;

import java.util.List;

public interface IProfessionDtoRepository {
    List<ProfessionDto> findProfessionsByActiveTrue();

    List<ProfessionDto> findProfessionsByTeacherId(Long id);
}
