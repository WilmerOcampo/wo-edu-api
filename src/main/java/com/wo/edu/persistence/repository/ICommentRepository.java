package com.wo.edu.persistence.repository;

import com.wo.edu.persistence.entity.course.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTeacherIdAndTopicId(Long teacherId, Long topicId);

    List<Comment> findByTopicIdAndUserId(Long topicId, Long userId);


    List<Comment> findCommentsByTeacherId(Long teacherId);

    List<Comment> findCommentsByTopicId(Long topicId);

    List<Comment> findCommentsByUserId(Long userId);
}
