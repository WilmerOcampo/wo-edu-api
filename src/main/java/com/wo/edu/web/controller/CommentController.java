package com.wo.edu.web.controller;

import com.wo.edu.domain.dto.CommentDto;
import com.wo.edu.domain.service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
@CrossOrigin
public class CommentController {
    private final ICommentService commentService;

    @GetMapping("/teacher/{id}")
    public ResponseEntity<List<CommentDto>> findCommentsByTeacherId(@PathVariable("id") Long teacherId) {
        return new ResponseEntity<>(commentService.findCommentsByTeacherId(teacherId), HttpStatus.OK);
    }

    @GetMapping("/topic/{id}")
    public ResponseEntity<List<CommentDto>> findCommentsByTopicId(@PathVariable("id") Long topicId) {
        return new ResponseEntity<>(commentService.findCommentsByTopicId(topicId), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<CommentDto>> findCommentsByUserId(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(commentService.findCommentsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CommentDto>> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(commentService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<CommentDto> save(@RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.save(commentDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        if (commentService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
