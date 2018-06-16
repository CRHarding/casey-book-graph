package com.example.usersapi.resolver;

import com.example.usersapi.model.User;
import com.example.usersapi.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private UserRepository userRepository;

    @Autowired
    public Mutation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public User createUser(String username, String firstName, String lastName, String email, String aboutMe, String password) {
//        User user = new User();
//        user.setUsername(username);
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setEmail(email);
//        user.setAboutMe(aboutMe);
//        user.setPassword(password);
//        System.out.println("Here in create user--->" + user);
//        return userRepository.save(user);
//    }

//    public User save(User user) {
//        System.out.println("In save--->" + user);
//        return userRepository.save(user);
//    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}