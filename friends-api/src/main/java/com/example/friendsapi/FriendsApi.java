package com.example.friendsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FriendsApi {

public static void main(String[] args) {
		SpringApplication.run(FriendsApi.class, args);
		}
}
