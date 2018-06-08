package com.example.users.post;

import com.example.users.post.Post;
import com.example.users.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PostsController {

    private final PostRepository postRepository;

    @Autowired
    public PostsController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/api/posts")
    public Iterable<Post> findAllPosts () {
        return postRepository.findAll ();
    }

    @GetMapping("/api/posts/{postId}")
    public Optional<Post> findpostById(@PathVariable Long postId) {
        return postRepository.findById(postId);
    }

    @DeleteMapping("/api/posts/{postId}")
    public HttpStatus deletePostById(@PathVariable Long postId) {
        postRepository.deleteById(postId);
        return HttpStatus.OK;
    }

//    @PostMapping("/api/{userId}/posts") {
//
//    }

    @PutMapping("/api/posts/{postId}")
    public Post updatePostById(@PathVariable Long postId, @RequestBody Post postRequest) {
        Post postFromDb = postRepository.findById(postId).get();

        postFromDb.setTitle(postRequest.getTitle());
        postFromDb.setPostText(postRequest.getPostText());
        postFromDb.setNumberOfLikes(postRequest.getNumberOfLikes());
        postFromDb.setNumberOfComments(postRequest.getNumberOfComments());
        postFromDb.setAbleToView(postRequest.getAbleToView());

        return postRepository.save(postFromDb);
    }

    @GetMapping("/api/posts/user/{userId}")
    public Iterable<Post> getByPosterId(@PathVariable int userId) {
        return postRepository.getByPosterId (userId);
    }
}