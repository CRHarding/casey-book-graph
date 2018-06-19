package com.example.usersapi.resolver;

import com.example.usersapi.model.User;
import com.example.usersapi.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private UserRepository userRepository;

    public Mutation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteUser(Long id) {
        System.out.println("HERE IN DELETE USER--->" + id);
        return userRepository.deleteById(id);
    }

    @Transactional
    public User updateUser(User newUser) {
        User user = userRepository.findById(newUser.getId()).get();
        user.setUsername(newUser.getUsername());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setAboutMe(newUser.getAboutMe());
        user.setPassword(newUser.getPassword());
        return user;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}