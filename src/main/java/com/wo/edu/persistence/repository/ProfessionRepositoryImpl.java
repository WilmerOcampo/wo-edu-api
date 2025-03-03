package com.wo.edu.persistence.repository;

import com.wo.edu.domain.dto.ProfessionDto;
import com.wo.edu.domain.repository.IProfessionDtoRepository;
import com.wo.edu.persistence.entity.course.Profession;
import com.wo.edu.persistence.mapper.IProfessionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProfessionRepositoryImpl implements IProfessionDtoRepository {
    private final IProfessionRepository professionRepository;
    private final IProfessionMapper professionMapper;

    @Override
    public List<ProfessionDto> findProfessionsByActiveTrue() {
        List<Profession> professions = professionRepository.findProfessionsByActiveTrue();
        return professionMapper.toProfessionsDto(professions);
    }

    @Override
    public List<ProfessionDto> findProfessionsByTeacherId(Long id) {
        List<Profession> professions = professionRepository.findProfessionsByTeachers_Id(id);
        return professionMapper.toProfessionsDto(professions);
    }
}
