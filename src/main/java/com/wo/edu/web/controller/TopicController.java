package com.wo.edu.web.controller;

import com.wo.edu.domain.dto.TopicDto;
import com.wo.edu.domain.service.ITopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topic")
@RequiredArgsConstructor
@CrossOrigin
public class TopicController {
    private final ITopicService topicService;

    @PostMapping("/save")
    public ResponseEntity<TopicDto> save(@RequestBody TopicDto topicDto) {
        return new ResponseEntity<>(topicService.save(topicDto), HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<TopicDto>> findAll() {
        return new ResponseEntity<>(topicService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDto> findById(@PathVariable("id") Long id) {
        return topicService.findById(id)
                .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        if (topicService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
