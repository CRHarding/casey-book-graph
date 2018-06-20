package com.example.usersapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.example.usersapi.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    int deleteById(long id);
    Optional<User> findById(long id);
    List<User> findAll();
}