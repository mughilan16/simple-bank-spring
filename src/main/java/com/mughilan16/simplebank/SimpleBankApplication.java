package com.mughilan16.simplebank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleBankApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SimpleBankApplication.class);
        application.run(args);
    }

    @GetMapping("/ping")
    public String ping() {
        return "Pong";
    }
}

