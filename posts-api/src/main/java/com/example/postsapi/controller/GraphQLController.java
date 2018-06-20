package com.example.postsapi.controller;

import com.example.postsapi.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
public class GraphQLController {

    private PostsService postsService;

    @Autowired
    public GraphQLController(PostsService postsService) {
        this.postsService = postsService;
    }

    @RequestMapping(value = "/graphql", method = RequestMethod.POST)
    public Object handle(@RequestBody Map query) {
        return postsService.resolve(query);
    }

}