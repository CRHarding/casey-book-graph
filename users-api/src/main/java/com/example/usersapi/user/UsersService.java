package com.example.usersapi.user;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GraphQLQuery(name = "users")
    public List<User> getUsers () {
        return userRepository.findAll ();
    }

    @GraphQLQuery(name = "user")
    public Optional<User> getUserById(@GraphQLArgument(name = "id") Long id) {
        return userRepository.findById(id);
    }

    @GraphQLMutation(name = "deleteUser")
    public void deleteUser(@GraphQLArgument(name="id") Long id) {
        userRepository.deleteById(id);
    }

    @GraphQLMutation(name = "saveUser")
    public User saveUser(@GraphQLArgument(name="user") User user) {
        return userRepository.save(user);
    }

//    @GraphQLMutation(name = "editUser")
//    public User updateUserById(@GraphQLArgument(name="id") Long userId, @GraphQLArgument(name="user") User userRequest) {
//        User userFromDb = userRepository.findById(userId).get();
//
//        userFromDb.setFirstName(userRequest.getFirstName());
//        userFromDb.setLastName(userRequest.getLastName());
//
//        return UserRepository.save(userFromDb);
//    }
}