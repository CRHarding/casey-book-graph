package com.example.usersapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableEurekaClient
public class UsersApi {

public static void main(String[] args) {
		SpringApplication.run(UsersApi.class, args);
	}
}

//@ComponentScan(basePackages = "com.example.usersapi")
