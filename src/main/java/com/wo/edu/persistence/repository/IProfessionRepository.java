package com.wo.edu.persistence.repository;

import com.wo.edu.persistence.entity.course.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfessionRepository extends JpaRepository<Profession, Long> {
    List<Profession> findProfessionsByActiveTrue();

    List<Profession> findProfessionsByTeachers_Id(Long id);
}
