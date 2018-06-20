package com.example.postsapi.configuration;

import com.example.postsapi.resolver.Mutation;
import com.example.postsapi.resolver.Query;
import com.example.postsapi.repository.PostRepository;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.coxautodev.graphql.tools.SchemaParser.newParser;

@Configuration
public class GraphQLConfiguration {

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
                .resolvers(query,mutation)
                .build()
                .makeExecutableSchema();
    }

}