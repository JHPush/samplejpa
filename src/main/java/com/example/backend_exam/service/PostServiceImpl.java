package com.example.backend_exam.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.backend_exam.domain.Post;
import com.example.backend_exam.dto.PostDto;
import com.example.backend_exam.repository.PostRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    
    @Override
    public PostDto retrievePost(Long id) {
        
        Optional<Post> result = postRepository.findById(id.longValue());
        
        Post post = result.orElseThrow(() -> new IllegalStateException(id + " 번 없음"));

        return entityToDto(post);
    }


    @Transactional(readOnly = false)
    @Override
    public Long registerPost(PostDto postDto) {

        Post post = dtoToEntity(postDto);
        postRepository.save(post);

        return post.getId();
    }

    @Transactional(readOnly = false)
    @Override
    public Long updatePost(Long id,PostDto postDto) {

        Post post = dtoToEntity(postDto);
        post.setId(id);
        postRepository.save(post);

        return post.getId();
    }


    @Override    
    public List<PostDto> retrieveAll() {
        List<PostDto> posts = postRepository.findAll().stream().map(post -> entityToDto(post)).collect(Collectors.toList());
        return posts;
    }
    @Override
    @Transactional(readOnly = false)
    public Long deletePost(Long id) {
        log.info("delete id : {}", id.intValue());
        postRepository.deleteById(id);
        return id;
    }
}
