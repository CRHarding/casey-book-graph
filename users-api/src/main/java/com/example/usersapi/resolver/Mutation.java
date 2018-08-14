package com.example.usersapi.resolver;

import com.example.usersapi.model.User;
import com.example.usersapi.repository.UserRepository;
import com.example.usersapi.model.Post;
import com.example.usersapi.repository.PostRepository;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public Mutation(UserRepository userRepository, PostRepository postRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteUser(Long id) {
        System.out.println("HERE IN DELETE USER--->" + id);
        return userRepository.deleteById(id);
    }

    @Transactional
    public User updateUser(User newUser) {
        User user = userRepository.findUserById(newUser.getId()).get();
        user.setUsername(newUser.getUsername());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setAboutMe(newUser.getAboutMe());
        user.setPassword(newUser.getPassword());
        return user;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deletePost(Long id) {
        System.out.println("HERE IN DELETE POST--->" + id);
        return postRepository.deleteById(id);
    }

    @Transactional
    public Post updatePost(Post newPost) {
        Post post = postRepository.findPostById(newPost.getId()).get();
        post.setTitle(newPost.getTitle());
        post.setPostText(newPost.getPostText());
        post.setNumberOfLikes(newPost.getNumberOfLikes());
        post.setNumberOfComments(newPost.getNumberOfComments());
        post.setAbleToView(newPost.getAbleToView());
        return post;
    }

    @Transactional
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}
