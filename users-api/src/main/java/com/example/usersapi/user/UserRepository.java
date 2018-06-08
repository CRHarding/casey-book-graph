package com.example.users.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User save(User user);
    User getUserByUsername(String username);
    User getUserById(long id);
    Optional<User> findById(long id);
    HttpStatus deleteById(long id);
}