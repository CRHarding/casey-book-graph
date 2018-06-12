package com.example.usersapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UserRepository UserRepository;

    public UsersController(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @GetMapping("/users")
    public Iterable<User> findAllUsers () {
        return UserRepository.findAll ();
    }

    @GetMapping("/users/{userId}")
    public Optional<User> findUserById(@PathVariable Long userId) {
        return UserRepository.findById(userId);
    }

    @GetMapping("/users/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return UserRepository.getUserByUsername(username);
    }

    @DeleteMapping("/users/{userId}")
    public HttpStatus deleteUserById(@PathVariable Long userId) {
        UserRepository.deleteById(userId);
        return HttpStatus.OK;
    }

    @PostMapping("/users")
    public void createNewUser(@RequestBody User newUser) {
        System.out.println(newUser);
        UserRepository.save(newUser);
    }

    @PatchMapping("/users/{userId}")
    public User updateUserById(@PathVariable Long userId, @RequestBody User userRequest) {
        User userFromDb = UserRepository.findById(userId).get();

        userFromDb.setFirstName(userRequest.getFirstName());
        userFromDb.setLastName(userRequest.getLastName());

        return UserRepository.save(userFromDb);
    }
}