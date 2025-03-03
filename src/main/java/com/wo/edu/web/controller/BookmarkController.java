package com.wo.edu.web.controller;

import com.wo.edu.domain.dto.BookmarkDto;
import com.wo.edu.domain.service.IBookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookmark")
@RequiredArgsConstructor
@CrossOrigin
public class BookmarkController {
    private final IBookmarkService bookmarkService;

    @GetMapping("/user/{id}")
    public ResponseEntity<Integer> countBookmarksByUserId(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(bookmarkService.countBookmarksByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Integer> countBookmarksByCourseId(@PathVariable("id") Long courseId) {
        return new ResponseEntity<>(bookmarkService.countBookmarksByCourseId(courseId), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<BookmarkDto> save(@RequestBody BookmarkDto bookmarkDto) {
        return new ResponseEntity<>(bookmarkService.save(bookmarkDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        if (bookmarkService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
