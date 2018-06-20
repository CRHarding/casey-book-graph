package com.example.usersapi.controller;

import com.example.usersapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
public class GraphQLController {

    private UsersService usersService;

    @Autowired
    public GraphQLController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "/graphql", method = RequestMethod.POST)
    public Object handle(@RequestBody Map query) {
        return usersService.resolve(query);
    }

}