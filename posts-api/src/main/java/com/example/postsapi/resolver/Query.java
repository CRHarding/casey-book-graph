package com.example.postsapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.postsapi.model.Post;
import com.example.postsapi.repository.PostRepository;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    private final PostRepository postRepository;

    @Autowired
    public Query(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> findPostById(long id) {
        System.out.println("Here in findPostbyId--->" + id);
        return postRepository.findById(id);
    }

    public List<Post> findAllPosts() {
        System.out.println("Here in all posts!");
        return postRepository.findAll();
    }
}