package com.wo.edu.domain.repository;

import com.wo.edu.domain.dto.BookmarkDto;

import java.util.Optional;

public interface IBookmarkDtoRepository {
    //List<BookmarkDto> findBookmarksByUserId(Long userId);
    Integer countBookmarksByUserId(Long userId);

    Integer countBookmarksByCourseId(Long courseId);

    Optional<BookmarkDto> findById(Long id);

    BookmarkDto save(BookmarkDto bookmarkDto);

    void deleteById(Long id);
}
