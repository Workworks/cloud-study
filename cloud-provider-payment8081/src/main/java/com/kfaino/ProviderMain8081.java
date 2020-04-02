package com.kfaino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderMain8081 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain8081.class,args);
    }
}
