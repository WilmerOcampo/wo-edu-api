package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.ProfessionDto;

import java.util.List;

public interface IProfessionService {
    List<ProfessionDto> findProfessionsByActiveTrue();

    List<ProfessionDto> findProfessionsByTeacherId(Long id);
}
