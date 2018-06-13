package com.example.usersapi.user;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.usersapi.user.User;

@Repository
interface UserRepository extends JpaRepository<User, Long> {
    void deleteById(long id);
    Optional<User> findById(long id);
    List<User> findAll();
}