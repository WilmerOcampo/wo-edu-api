package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.LikeDto;

import java.util.Optional;

public interface ILikeService {
    Integer countLikesByTopicId(Long topicId);

    Integer countLikesByTeacherId(Long teacherId);

    Integer countLikesByUserId(Long userId);

    Optional<LikeDto> findById(Long id);

    LikeDto save(LikeDto likeDto);

    Boolean deleteById(Long id);
}
