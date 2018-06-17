package com.example.usersapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.usersapi.model.User;
import com.example.usersapi.repository.UserRepository;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    private final UserRepository userRepository;

    @Autowired
    public Query(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserById(long id) {
        System.out.println("Here in findUserbyId--->" + id);
        return userRepository.findById(id);
    }

    public List<User> findAllUsers() {
        System.out.println("Here in all users!");
        return userRepository.findAll();
    }
}