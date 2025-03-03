package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.LikeDto;
import com.wo.edu.domain.repository.ILikeDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements ILikeService {
    private final ILikeDtoRepository likeDtoRepository;

    @Override
    public Integer countLikesByTopicId(Long topicId) {
        return likeDtoRepository.countLikesByTopicId(topicId);
    }

    @Override
    public Integer countLikesByTeacherId(Long teacherId) {
        return likeDtoRepository.countLikesByTeacherId(teacherId);
    }

    @Override
    public Integer countLikesByUserId(Long userId) {
        return likeDtoRepository.countLikesByUserId(userId);
    }

    @Override
    public Optional<LikeDto> findById(Long id) {
        return likeDtoRepository.findById(id);
    }

    @Override
    public LikeDto save(LikeDto likeDto) {
        return likeDtoRepository.save(likeDto);
    }

    @Override
    public Boolean deleteById(Long id) {
        return findById(id).map(product -> {
            likeDtoRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
