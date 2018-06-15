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
//        ExecutionResult executionResult = graphQL.execute (query.get ("query"));
//        System.out.println("Resolve----->" + executionResult);
//        return executionResult.getData ();

        String query = (String) body.get("query");
        Map<String, Object> variables = (Map<String, Object>) body.get("variables");
        if (variables == null) {
            variables = new LinkedHashMap<>();
        }
        ExecutionResult executionResult = graphQL.execute(query, (Object) null, variables);
        System.out.println("here in executionresult--->" + executionResult);
        Map<String, Object> result = new LinkedHashMap<>();
        if (executionResult.getErrors().size() > 0) {
            result.put("errors", executionResult.getErrors());
        }
        result.put("data", executionResult.getData());
        System.out.println("here in data--->" + result);
        return result;
    }
}

//    private final UserRepository userRepository;
//
//    public UsersService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @GraphQLQuery(name = "users")
//    public List<User> getUsers () {
//        return userRepository.findAll ();
//    }
//
//    @GraphQLQuery(name = "user")
//    public Optional<User> getUserById(@GraphQLArgument(name = "id") Long id) {
//        return userRepository.findById(id);
//    }
//
//    @GraphQLMutation(name = "deleteUser")
//    public void deleteUser(@GraphQLArgument(name="id") Long id) {
//        userRepository.deleteById(id);
//    }
//
//    @GraphQLMutation(name = "saveUser")
//    public User saveUser(@GraphQLArgument(name="user") User user) {
//        return userRepository.save(user);
//    }

//    @GraphQLMutation(name = "editUser")
//    public User updateUserById(@GraphQLArgument(name="id") Long userId, @GraphQLArgument(name="user") User userRequest) {
//        User userFromDb = userRepository.findById(userId).get();
//
//        userFromDb.setFirstName(userRequest.getFirstName());
//        userFromDb.setLastName(userRequest.getLastName());
//
//        return UserRepository.save(userFromDb);
//    }
//}