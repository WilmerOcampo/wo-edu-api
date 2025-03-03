package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.CommentDto;
import com.wo.edu.domain.repository.ICommentDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {
    private final ICommentDtoRepository commentDtoRepository;

    @Override
    public List<CommentDto> findCommentsByTeacherId(Long teacherId) {
        return commentDtoRepository.findCommentsByTeacherId(teacherId);
    }

    @Override
    public List<CommentDto> findCommentsByTopicId(Long topicId) {
        return commentDtoRepository.findCommentsByTopicId(topicId);
    }

    @Override
    public List<CommentDto> findCommentsByUserId(Long userId) {
        return commentDtoRepository.findCommentsByUserId(userId);
    }

    @Override
    public Optional<CommentDto> findById(Long id) {
        return commentDtoRepository.findById(id);
    }

    @Override
    public CommentDto save(CommentDto commentDto) {
        return commentDtoRepository.save(commentDto);
    }

    @Override
    public Boolean deleteById(Long id) {
        return findById(id).map(product -> {
            commentDtoRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
