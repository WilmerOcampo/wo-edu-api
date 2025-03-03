package com.wo.edu.persistence.repository;

import com.wo.edu.domain.dto.TopicDto;
import com.wo.edu.domain.repository.ITopicDtoRepository;
import com.wo.edu.persistence.entity.course.Topic;
import com.wo.edu.persistence.mapper.ITopicMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TopicRepositoryImpl implements ITopicDtoRepository {
    private final ITopicRepository topicRepository;
    private final ITopicMapper topicMapper;

    @Override
    public List<TopicDto> findAll() {
        List<Topic> topics = topicRepository.findAll();
        return topicMapper.toTopicsDto(topics);
    }

    @Override
    public Optional<TopicDto> findById(Long id) {
        return topicRepository.findById(id)
                .map(topicMapper::toTopicDto);
    }

    @Override
    public TopicDto save(TopicDto topicDto) {
        Topic topic = topicMapper.toTopic(topicDto);
        return topicMapper.toTopicDto(topicRepository.save(topic));
    }

    @Override
    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }
}
