package com.wo.edu.domain.repository;

import com.wo.edu.domain.dto.CommentDto;

import java.util.List;
import java.util.Optional;

public interface ICommentDtoRepository {
    List<CommentDto> findCommentsByTeacherId(Long teacherId);

    List<CommentDto> findCommentsByTopicId(Long topicId);

    List<CommentDto> findCommentsByUserId(Long userId);

    Optional<CommentDto> findById(Long id);

    CommentDto save(CommentDto commentDto);

    void deleteById(Long id);
}
