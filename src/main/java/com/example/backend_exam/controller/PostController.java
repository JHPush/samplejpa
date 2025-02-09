package com.example.backend_exam.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_exam.dto.PostDto;
import com.example.backend_exam.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class PostController {
    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Map<String, Long>> insertPost(@RequestBody PostDto postDto) {
        Long id = postService.registerPost(postDto);
        return new ResponseEntity<>(Map.of("id", id), HttpStatus.CREATED);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getPost() {
        return new ResponseEntity<>(postService.retrieveAll(), HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostDto> getPostView(@PathVariable("id") Long id) {

        PostDto postDto = postService.retrievePost(id);

        return new ResponseEntity(postDto, HttpStatus.OK);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Map<String, Long>> updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        Long mId = postService.updatePost(id,postDto);

        return new ResponseEntity<>(Map.of("id", mId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Map<String, Long>> deletePost(@PathVariable Long id) {
        Long mId = postService.deletePost(id);

        return new ResponseEntity<>(Map.of("id", mId), HttpStatus.ACCEPTED);
    }
}
