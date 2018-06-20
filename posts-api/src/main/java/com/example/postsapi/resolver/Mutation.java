package com.example.postsapi.resolver;

import com.example.postsapi.model.Post;
import com.example.postsapi.repository.PostRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private PostRepository postRepository;

    public Mutation(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deletePost(Long id) {
        System.out.println("HERE IN DELETE POST--->" + id);
        return postRepository.deleteById(id);
    }

    @Transactional
    public Post updatePost(Post newPost) {
        Post post = postRepository.findById(newPost.getId()).get();
        post.setTitle(newPost.getTitle());
        post.setPostText(newPost.getPostText());
        post.setNumberOfLikes(newPost.getNumberOfLikes());
        post.setNumberOfComments(newPost.getNumberOfComments());
        post.setAbleToView(newPost.getAbleToView());
        return post;
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}