package com.example.users.post;
import java.util.List;
import java.util.Optional;

import com.example.users.post.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> getByPosterId(int userId);
    Optional<Post> findById(long postId);
    HttpStatus deleteById(long postId);
}