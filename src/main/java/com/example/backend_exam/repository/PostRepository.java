package com.example.backend_exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend_exam.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT COUNT(p) FROM Post As p")
    long getTotalCount();

    @Query("SELECT p FROM Post p")
    List<Post> findAlls();


}
