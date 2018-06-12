package com.example.usersapi.user;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.Optional;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    private final UserRepository userRepository;

    public Query(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User user(long id) {
        return userRepository.findOne(id);
    }

    public Iterable<User> allUsers() {
        return userRepository.findAll();
    }
}