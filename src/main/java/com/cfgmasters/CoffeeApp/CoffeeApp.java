package com.cfgmasters.CoffeeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeeApp {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeApp.class, args);
        System.out.println("Welcome to the Beans and Grounds Coffee store!");
        System.out.println("You can see our API docs at http://localhost:7777/swagger-ui.html");
    }
}
