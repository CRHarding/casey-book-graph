package com.example.usersapi.resolver;

import com.example.usersapi.model.User;
import com.example.usersapi.repository.UserRepository;
import com.example.usersapi.model.Post;

import com.coxautodev.graphql.tools.GraphQLResolver;

public class PostResolver implements GraphQLResolver<Post> {
    private UserRepository userRepository;

    public PostResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User user(Post post) {
        return userRepository.findUserById(post.getPoster().getId()).get();
    }
}