package com.wo.edu.domain.repository;

import com.wo.edu.domain.dto.CategoryDto;

import java.util.List;

public interface ICategoryDtoRepository {
    List<CategoryDto> findCategoriesByActiveTrue();
}
