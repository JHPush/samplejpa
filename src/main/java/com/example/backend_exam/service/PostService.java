package com.example.backend_exam.service;

import java.util.List;

import com.example.backend_exam.domain.Post;
import com.example.backend_exam.dto.PostDto;

public interface PostService {

    PostDto retrievePost(Long id);
    Long registerPost(PostDto postDto);
    List<PostDto> retrieveAll();
    Long updatePost(Long id,PostDto postDto);
    Long deletePost(Long id);
    default Post dtoToEntity(PostDto dto) {
        return Post.builder()
                .title(dto.getTitle())
                .contents(dto.getContents())
                .writer(dto.getWriter())
                .regDate(dto.getRegDate())
                .build();

    }

    default PostDto entityToDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .contents(post.getContents())
                .writer(post.getWriter())
                .regDate(post.getRegDate())
                .build();

    }

}
