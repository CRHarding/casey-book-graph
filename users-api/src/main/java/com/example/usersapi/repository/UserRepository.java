package com.example.usersapi.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.usersapi.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    void deleteById(long id);
    Optional<User> findById(long id);
    List<User> findAll();
    User save(User user);
}