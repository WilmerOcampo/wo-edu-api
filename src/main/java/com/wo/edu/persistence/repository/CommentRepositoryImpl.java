package com.wo.edu.persistence.repository;

import com.wo.edu.domain.dto.CommentDto;
import com.wo.edu.domain.repository.ICommentDtoRepository;
import com.wo.edu.persistence.entity.course.Comment;
import com.wo.edu.persistence.entity.course.Topic;
import com.wo.edu.persistence.mapper.ICommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements ICommentDtoRepository {
    private final ICommentRepository commentRepository;
    private final ITopicRepository topicRepository;
    private final ICommentMapper commentMapper;

    @Override
    public List<CommentDto> findCommentsByTeacherId(Long teacherId) {
        List<Comment> comments = commentRepository.findCommentsByTeacherId(teacherId);
        return commentMapper.toCommentsDto(comments);
    }

    @Override
    public List<CommentDto> findCommentsByTopicId(Long topicId) {
        List<Comment> comments = commentRepository.findCommentsByTopicId(topicId);
        return commentMapper.toCommentsDto(comments);
    }

    @Override
    public List<CommentDto> findCommentsByUserId(Long userId) {
        List<Comment> comments = commentRepository.findCommentsByUserId(userId);
        return commentMapper.toCommentsDto(comments);
    }

    @Override
    public Optional<CommentDto> findById(Long id) {
        return commentRepository.findById(id)
                .map(commentMapper::toCommentDto);
    }

    @Override
    @Transactional
    public CommentDto save(CommentDto commentDto) {
        Comment comment = commentMapper.toComment(commentDto);

        Topic topic = topicRepository.findById(commentDto.getTopicId())
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        comment.setTopic(topic);
        return commentMapper.toCommentDto(commentRepository.save(comment));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
