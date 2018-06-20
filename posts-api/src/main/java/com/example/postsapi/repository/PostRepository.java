package com.example.postsapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.example.postsapi.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
    int deleteById(long id);
    Optional<Post> findById(long id);
    List<Post> findAll();
}