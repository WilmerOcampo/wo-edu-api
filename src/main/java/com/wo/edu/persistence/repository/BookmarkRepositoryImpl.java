package com.wo.edu.persistence.repository;

import com.wo.edu.domain.dto.BookmarkDto;
import com.wo.edu.domain.repository.IBookmarkDtoRepository;
import com.wo.edu.persistence.entity.user.Bookmark;
import com.wo.edu.persistence.entity.user.User;
import com.wo.edu.persistence.mapper.IBookmarkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookmarkRepositoryImpl implements IBookmarkDtoRepository {
    private final IBookmarkRepository bookmarkRepository;
    private final IBookmarkMapper bookmarkMapper;
    private final IUserRepository userRepository;

    @Override
    public Integer countBookmarksByUserId(Long userId) {
        return bookmarkRepository.countBookmarksByUserId(userId);
    }

    @Override
    public Integer countBookmarksByCourseId(Long courseId) {
        return bookmarkRepository.countBookmarksByCourseId(courseId);
    }

 /*   @Override
    public List<BookmarkDto> findAll() {
        List<Bookmark> bookmarks = bookmarkRepository.findAll();
        return bookmarkMapper.toBookmarksDto(bookmarks);
    }*/

    /*@Override
    public List<BookmarkDto> findBookmarksByUserId(Long userId) {
        List<Bookmark> bookmarks = bookmarkRepository.findBookmarksByUserId(userId);
        return bookmarkMapper.toBookmarksDto(bookmarks);
    }*/

    @Override
    public Optional<BookmarkDto> findById(Long id) {
        return bookmarkRepository.findById(id).map(bookmarkMapper::toBookmarkDto);
    }

    @Override
    @Transactional
    public BookmarkDto save(BookmarkDto bookmarkDto) {
        Bookmark bookmark = bookmarkMapper.toBookmark(bookmarkDto);
        User user = userRepository.findById(bookmarkDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        bookmark.setUser(user);
        return bookmarkMapper.toBookmarkDto(bookmarkRepository.save(bookmark));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        bookmarkRepository.deleteById(id);
    }
}
