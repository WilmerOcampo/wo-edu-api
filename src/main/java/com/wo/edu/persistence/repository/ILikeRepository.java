package com.wo.edu.persistence.repository;

import com.wo.edu.persistence.entity.course.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILikeRepository extends JpaRepository<Like, Long> {
    Integer countLikesByTopicId(Long topicId);

    Integer countLikesByTeacherId(Long teacherId);

    Integer countLikesByUserId(Long userId);


    List<Like> findByTeacherIdAndTopicId(Long teacherId, Long topicId);

    List<Like> findByTeacherId(Long teacherId);

    List<Like> findByUserId(Long userId);

    List<Like> findByUserIdAndTopicId(Long userId, Long topicId);

    List<Like> findByTopicId(Long topicId);
}
