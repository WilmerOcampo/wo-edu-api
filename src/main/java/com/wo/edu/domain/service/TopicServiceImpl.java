package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.TopicDto;
import com.wo.edu.domain.repository.ITopicDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements ITopicService {
    private final ITopicDtoRepository topicDtoRepository;

    @Override
    public List<TopicDto> findAll() {
        return topicDtoRepository.findAll();
    }

    @Override
    public Optional<TopicDto> findById(Long id) {
        return topicDtoRepository.findById(id);
    }

    @Override
    public TopicDto save(TopicDto topicDto) {
        return topicDtoRepository.save(topicDto);
    }

    @Override
    public Boolean deleteById(Long id) {
        return findById(id).map(c -> {
            topicDtoRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
