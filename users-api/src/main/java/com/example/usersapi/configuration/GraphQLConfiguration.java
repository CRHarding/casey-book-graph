package com.example.usersapi.configuration;

import com.example.usersapi.resolver.Mutation;
import com.example.usersapi.resolver.Query;
import com.example.usersapi.repository.UserRepository;
import com.example.usersapi.repository.PostRepository;
import com.example.usersapi.resolver.PostResolver;
import com.example.usersapi.resolver.UserResolver;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.coxautodev.graphql.tools.SchemaParser.newParser;

@Configuration
public class GraphQLConfiguration {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private Query query;

    @Autowired
    private Mutation mutation;

    @Bean
    public GraphQL graphQL() {
        return GraphQL.newGraphQL(graphQLSchema())
                .build();
    }

    @Bean
    public GraphQLSchema graphQLSchema() {
        return newParser()
                .file("schema.graphqls")
                .resolvers(query,mutation, new PostResolver(userRepository))
                .build()
                .makeExecutableSchema();
    }

}