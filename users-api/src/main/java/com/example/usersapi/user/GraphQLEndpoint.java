//package com.example.usersapi.user;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import graphql.schema.GraphQLSchema;
//import graphql.servlet.GraphQLContext;
//import graphql.servlet.GraphQLServlet;
//
//@WebServlet("/graphql")
//public class GraphQLEndpoint extends GraphQLServlet {
//
//    public GraphQLEndpoint() {
//        super(buildSchema());
//    }
//
//    private static GraphQLSchema buildSchema() {
//        UserRepository userRepository = new UserRepository();
//        return SchemaParser.newParser()
//                .file("prisma/generated/prisma.graphql")
//                .resolvers(new Query(userRepository))
//                .build()
//                .makeExecutableSchema();
//    }
//}