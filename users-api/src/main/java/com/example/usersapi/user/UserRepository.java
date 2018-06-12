package com.example.usersapi.user;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User save(User user);
    User getUserByUsername(String username);
    User getUserById(long id);
    Optional<User> findById(long id);
    void deleteById(long id);
}