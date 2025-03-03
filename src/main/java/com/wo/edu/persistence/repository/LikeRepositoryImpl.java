package com.wo.edu.persistence.repository;

import com.wo.edu.domain.dto.LikeDto;
import com.wo.edu.domain.repository.ILikeDtoRepository;
import com.wo.edu.persistence.entity.course.Like;
import com.wo.edu.persistence.entity.course.Topic;
import com.wo.edu.persistence.mapper.ILikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LikeRepositoryImpl implements ILikeDtoRepository {
    private final ILikeRepository likeRepository;
    private final ITopicRepository topicRepository;
    private final ILikeMapper likeMapper;

    @Override
    public Integer countLikesByTopicId(Long topicId) {
        return likeRepository.countLikesByTopicId(topicId);
    }

    @Override
    public Integer countLikesByTeacherId(Long teacherId) {
        return likeRepository.countLikesByTeacherId(teacherId);
    }

    @Override
    public Integer countLikesByUserId(Long userId) {
        return likeRepository.countLikesByUserId(userId);
    }

    @Override
    public Optional<LikeDto> findById(Long id) {
        return likeRepository.findById(id).map(likeMapper::toLikeDto);
    }

    @Override
    @Transactional
    public LikeDto save(LikeDto likeDto) {
        Like like = likeMapper.toLike(likeDto);

        Topic topic = topicRepository.findById(likeDto.getTopicId())
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        like.setTopic(topic);
        return likeMapper.toLikeDto(likeRepository.save(like));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        likeRepository.deleteById(id);
    }
}
