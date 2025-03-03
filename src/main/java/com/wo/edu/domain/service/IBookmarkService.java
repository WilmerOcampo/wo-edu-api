package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.BookmarkDto;

import java.util.Optional;

public interface IBookmarkService {
    //List<BookmarkDto> findBookmarksByUserId(Long userId);
    Integer countBookmarksByUserId(Long userId);

    Integer countBookmarksByCourseId(Long courseId);

    Optional<BookmarkDto> findById(Long id);

    BookmarkDto save(BookmarkDto bookmarkDto);

    Boolean deleteById(Long id);
}
