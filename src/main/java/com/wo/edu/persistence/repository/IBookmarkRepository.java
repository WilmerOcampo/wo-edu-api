package com.wo.edu.persistence.repository;

import com.wo.edu.persistence.entity.user.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookmarkRepository extends JpaRepository<Bookmark, Long> {
    Integer countBookmarksByUserId(Long userId);

    Integer countBookmarksByCourseId(Long courseId);

    List<Bookmark> findBookmarksByUserId(Long userId);

    List<Bookmark> findByUserIdAndCourseId(Long userId, Long courseId);
}
