package com.example.usersapi.resolver;

import com.example.usersapi.model.User;
import com.example.usersapi.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLRootResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLRootResolver {

    private UserRepository userRepository;

    @Autowired
    public Mutation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String firstName, String lastName, String email, String aboutMe, String password) {
        User user = new User(username, firstName, lastName, email, aboutMe, password);
        userRepository.save(user);
        return user;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}