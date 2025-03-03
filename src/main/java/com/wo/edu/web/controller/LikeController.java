package com.wo.edu.web.controller;

import com.wo.edu.domain.dto.LikeDto;
import com.wo.edu.domain.service.ILikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/like")
@RequiredArgsConstructor
@CrossOrigin
public class LikeController {
    private final ILikeService likeService;

    @GetMapping("/topic/{id}")
    public ResponseEntity<Integer> countLikesByTopicId(@PathVariable("id") Long topicId) {
        return new ResponseEntity<>(likeService.countLikesByTopicId(topicId), HttpStatus.OK);
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Integer> countLikesByTeacherId(@PathVariable("id") Long teacherId) {
        return new ResponseEntity<>(likeService.countLikesByTeacherId(teacherId), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Integer> countLikesByUserId(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(likeService.countLikesByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<LikeDto> save(@RequestBody LikeDto likeDto) {
        return new ResponseEntity<>(likeService.save(likeDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        if (likeService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
