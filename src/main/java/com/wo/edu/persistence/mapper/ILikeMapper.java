package com.wo.edu.persistence.mapper;

import com.wo.edu.domain.dto.LikeDto;
import com.wo.edu.persistence.entity.course.Like;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ILikeMapper {
    @Mapping(target = "topicId", ignore = true)
    LikeDto toLikeDto(Like like);

    List<LikeDto> toLikesDto(List<Like> likes);

    @InheritInverseConfiguration
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "topic", ignore = true)
    Like toLike(LikeDto likeDto);
}
