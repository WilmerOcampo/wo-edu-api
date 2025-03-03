package com.wo.edu.persistence.mapper;

import com.wo.edu.domain.dto.ProfessionDto;
import com.wo.edu.persistence.entity.course.Profession;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProfessionMapper {
    ProfessionDto toProfessionDto(Profession profession);

    List<ProfessionDto> toProfessionsDto(List<Profession> professions);

    @InheritInverseConfiguration
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    Profession toProfession(ProfessionDto professionDto);
}
