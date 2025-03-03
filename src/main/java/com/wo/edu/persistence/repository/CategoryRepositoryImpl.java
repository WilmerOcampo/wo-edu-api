package com.wo.edu.persistence.repository;

import com.wo.edu.domain.dto.CategoryDto;
import com.wo.edu.domain.repository.ICategoryDtoRepository;
import com.wo.edu.persistence.entity.course.Category;
import com.wo.edu.persistence.mapper.ICategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements ICategoryDtoRepository {
    private final ICategoryRepository categoryRepository;
    private final ICategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> findCategoriesByActiveTrue() {
        List<Category> categories = categoryRepository.findCategoriesByActiveTrue();
        return categoryMapper.toCategoriesDto(categories);
    }
}
