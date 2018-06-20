package com.example.usersapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.example.usersapi.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
    int deleteById(long id);
    Optional<Post> findPostById(long id);
    List<Post> findAll();
}