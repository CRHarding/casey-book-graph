package com.example.usersapi.resolver;

import com.example.usersapi.model.User;
import com.example.usersapi.repository.UserRepository;
import com.example.usersapi.model.Post;

import com.coxautodev.graphql.tools.GraphQLResolver;

public class UserResolver implements GraphQLResolver<User> {
    private UserRepository userRepository;

    public UserResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User user(int id) {
        return userRepository.findUserById(id).get();
    }
}