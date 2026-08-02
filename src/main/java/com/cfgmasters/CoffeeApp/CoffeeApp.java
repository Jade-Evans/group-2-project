package com.cfgmasters.CoffeeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CoffeeApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CoffeeApp.class, args);
        String serverPort = context.getEnvironment().getProperty("server.port", "8080");
        System.out.println("Welcome to the Beans and Grounds Coffee store!");
        System.out.println("You can see our API docs at http://localhost:" + serverPort + "/swagger-ui.html");
    }
}
