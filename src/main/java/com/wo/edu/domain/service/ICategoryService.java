package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.CategoryDto;

import java.util.List;

public interface ICategoryService {
    List<CategoryDto> findCategoriesByActiveTrue();
}
