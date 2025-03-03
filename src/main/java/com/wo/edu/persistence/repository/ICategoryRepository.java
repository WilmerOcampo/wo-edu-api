package com.wo.edu.persistence.repository;

import com.wo.edu.persistence.entity.course.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findCategoriesByActiveTrue();
}
