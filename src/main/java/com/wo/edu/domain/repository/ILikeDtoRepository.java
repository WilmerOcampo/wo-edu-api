package com.wo.edu.domain.repository;

import com.wo.edu.domain.dto.LikeDto;

import java.util.Optional;

public interface ILikeDtoRepository {
    Integer countLikesByTopicId(Long topicId);

    Integer countLikesByTeacherId(Long teacherId);

    Integer countLikesByUserId(Long userId);

    Optional<LikeDto> findById(Long id);

    LikeDto save(LikeDto likeDto);

    void deleteById(Long id);
}
