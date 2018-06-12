package com.example.usersapi.user;

import org.springframework.stereotype.Component;
import lombok.*;
import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
@AllArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {
    private UserRepository userRepository;

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findOne(id);
    }
}