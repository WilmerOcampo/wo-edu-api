package com.wo.edu.persistence.repository;

import com.wo.edu.persistence.entity.course.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findTopicsByActiveTrue();

    List<Topic> findByTeacherId(Long teacherId);

    List<Topic> findByCourses_Id(Long courseId);

    List<Topic> findTopicsByTitleLikeIgnoreCaseOrDescriptionLikeIgnoreCase(String title, String description);
}
