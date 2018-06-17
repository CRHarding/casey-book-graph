package com.example.usersapi.service;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.LinkedHashMap;

@Service
public class UsersService {

    private GraphQL graphQL;

    @Autowired
    UsersService(GraphQL graphQL) {
        this.graphQL = graphQL;
    }

    public Object resolve(Map body) {
        String query = (String) body.get("query");
        Map<String, Object> variables = (Map<String, Object>) body.get("variables");
        if (variables == null) {
            variables = new LinkedHashMap<>();
        }

        ExecutionResult executionResult = graphQL.execute(query, (Object) null, variables);
        Map<String, Object> result = new LinkedHashMap<>();
        if (executionResult.getErrors().size() > 0) {
            result.put("errors", executionResult.getErrors());
        }
        result.put("data", executionResult.getData());
        return result;
    }
}