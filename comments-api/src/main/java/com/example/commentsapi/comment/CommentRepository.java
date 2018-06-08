package com.example.users.comment;
import java.util.List;
import java.util.Optional;

import com.example.users.comment.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByCommenterId(int commenterId);
    List<Comment> findByPostId(int postId);
    Optional<Comment> findById(long postId);
    HttpStatus deleteById(long postId);
}