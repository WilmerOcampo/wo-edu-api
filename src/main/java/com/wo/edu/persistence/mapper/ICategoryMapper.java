package com.wo.edu.persistence.mapper;

import com.wo.edu.domain.dto.CategoryDto;
import com.wo.edu.persistence.entity.course.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    CategoryDto toCategoryDto(Category category);

    List<CategoryDto> toCategoriesDto(List<Category> categories);

    @InheritInverseConfiguration
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "courses", ignore = true)
    Category toCategory(CategoryDto categoryDto);
}
