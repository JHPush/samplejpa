package com.example.backend_exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend_exam.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


}
