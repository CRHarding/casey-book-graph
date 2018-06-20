package com.example.usersapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.usersapi.model.User;
import com.example.usersapi.repository.UserRepository;
import com.example.usersapi.model.Post;
import com.example.usersapi.repository.PostRepository;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public Query(UserRepository userRepository, PostRepository postRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Optional<User> findUserById(long id) {
        return userRepository.findUserById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Post> findPostById(long id) {
        return postRepository.findPostById(id);
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
}