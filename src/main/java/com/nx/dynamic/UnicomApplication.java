package com.nx.dynamic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class UnicomApplication extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(UnicomApplication.class, args);
    }
}
