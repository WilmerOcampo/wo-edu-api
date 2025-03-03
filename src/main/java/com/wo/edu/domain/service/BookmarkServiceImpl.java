package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.BookmarkDto;
import com.wo.edu.domain.repository.IBookmarkDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookmarkServiceImpl implements IBookmarkService {
    private final IBookmarkDtoRepository bookmarkDtoRepository;

    /*@Override
    public List<BookmarkDto> findAll() {
        return bookmarkDtoRepository.findAll();
    }*/

    /*@Override
    public List<BookmarkDto> findBookmarksByUserId(Long userId) {
        return bookmarkDtoRepository.findBookmarksByUserId(userId);
    }*/

    @Override
    public Integer countBookmarksByUserId(Long userId) {
        return bookmarkDtoRepository.countBookmarksByUserId(userId);
    }

    @Override
    public Integer countBookmarksByCourseId(Long courseId) {
        return bookmarkDtoRepository.countBookmarksByCourseId(courseId);
    }

    @Override
    public Optional<BookmarkDto> findById(Long id) {
        return bookmarkDtoRepository.findById(id);
    }

    @Override
    public BookmarkDto save(BookmarkDto bookmarkDto) {
        return bookmarkDtoRepository.save(bookmarkDto);
    }

    @Override
    public Boolean deleteById(Long id) {
        return findById(id).map(product -> {
            bookmarkDtoRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
