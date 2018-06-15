//package com.example.usersapi.user;
//
//import graphql.ExecutionInput;
//import graphql.ExecutionResult;
//import graphql.GraphQL;
//import graphql.schema.GraphQLSchema;
//import io.leangen.graphql.GraphQLSchemaGenerator;
//import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
//import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
//
//import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import io.leangen.graphql.metadata.strategy.type.DefaultTypeTransformer;
//import org.springframework.data.jpa.repository.JpaRepository;
//import io.leangen.geantyref.*;
//
//import com.example.usersapi.user.UsersService;
//import javax.servlet.http.HttpServletRequest;
//import java.util.Map;
//
//@RestController
//public class GraphQLController {
//
//    private final GraphQL graphQL;
//
//    public GraphQLController(UsersService usersService) {
////        Query query = new Query(UsersService);
////        Mutation mutation = new Mutation(UsersService);
////        graphql = new GraphQLSchemaGenerator().withOperationsFromSingletons(query).generate();
//
//        HashMap<User, Long> repoType = new HashMap<>();
//        repoType = TypeFactory.parameterizedClass(usersService.getRepositoryInterface(), entityType.getJavaType(), entityType.getIdType());
//        GraphQLSchema schema =
//                new GraphQLSchemaGenerator()
//                        .withOperationsFromSingleton (repoType)
//                        .withResolverBuilders (
//                                new PublicResolverBuilder("com.example.usersapi.user"))
//                        .generate ();
//        graphQL = GraphQL.newGraphQL (schema).build ();
//    }
//
//    @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    public Map<String, Object> graphql(@RequestBody Map<String, String> request, HttpServletRequest raw) {
//        ExecutionResult executionResult =
//                graphQL.execute (ExecutionInput.newExecutionInput ()
//                        .query (request.get ("query"))
//                        .operationName (request.get ("operationName"))
//                        .context (raw)
//                        .build ());
//        return executionResult.toSpecification ();
//    }
//}

//package com.example.usersapi.user;
//
//import graphql.ExecutionInput;
//import graphql.ExecutionResult;
//import graphql.GraphQL;
//import graphql.schema.GraphQLSchema;
//import io.leangen.graphql.GraphQLSchemaGenerator;
//import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
//import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
//import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import io.leangen.geantyref.*;
//import org.springframework.data.repository.core.RepositoryMetadata;
//import javax.persistence.metamodel.EntityType;
//import java.util.Optional;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Map;
//import java.util.HashMap;
//
//@RestController
//public class GraphQLController {
//
//    private final GraphQL graphQL;
//
//    public GraphQLController(UsersService usersService) {
//        Optional op = usersService.getRepositoryFor(entityType.getJavaType());
//        Optional<RepositoryInformation> info = usersService.getRepositoryInformationFor(entityType.getJavaType());
//
//        UsersService repoType = TypeFactory.parameterizedClass(info.get().getRepositoryInterface(), entityType.getJavaType(), entityType.getIdType());
//
//        GraphQLSchema schema = new GraphQLSchemaGenerator()
//                .withOperationsFromSingleton(op.get(), repoType)
//                .generate();
//        graphQL = GraphQL.newGraphQL(schema).build();
//    }
//
//    @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    public Map<String, Object> graphql(@RequestBody Map<String, String> request, HttpServletRequest raw) {
//        ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput()
//                .query(request.get("query"))
//                .operationName(request.get("operationName"))
//                .context(raw)
//                .build());
//        return executionResult.toSpecification();
//    }
//}


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

    @RequestMapping(value = "/graphql",method = RequestMethod.POST)
    public Object handle(@RequestBody Map query) {
        System.out.println("here--->" + query);
        return usersService.resolve(query);
    }

}