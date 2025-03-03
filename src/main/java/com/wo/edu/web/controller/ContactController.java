package com.wo.edu.web.controller;

import com.wo.edu.domain.dto.ContactDto;
import com.wo.edu.domain.service.IContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
@CrossOrigin
public class ContactController {
    private final IContactService contactService;

    @GetMapping("/all")
    public ResponseEntity<List<ContactDto>> findAll() {
        return new ResponseEntity<>(contactService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDto> findById(@PathVariable("id") Long id) {
        return contactService.findById(id)
                .map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ContactDto> save(@RequestBody ContactDto contactDto) {
        return new ResponseEntity<>(contactService.save(contactDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        if (contactService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
