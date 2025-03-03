package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.CategoryDto;
import com.wo.edu.domain.repository.ICategoryDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryDtoRepository categoryDtoRepository;

    @Override
    public List<CategoryDto> findCategoriesByActiveTrue() {
        return categoryDtoRepository.findCategoriesByActiveTrue();
    }
}
