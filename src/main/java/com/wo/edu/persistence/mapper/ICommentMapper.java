package com.wo.edu.persistence.mapper;

import com.wo.edu.domain.dto.CommentDto;
import com.wo.edu.persistence.entity.course.Comment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICommentMapper {
    @Mapping(target = "topicId", ignore = true)
    CommentDto toCommentDto(Comment comment);

    List<CommentDto> toCommentsDto(List<Comment> comments);

    @InheritInverseConfiguration
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "topic", ignore = true)
    Comment toComment(CommentDto commentDto);
}
