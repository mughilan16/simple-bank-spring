package com.mughilan16.simplebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simple_bank", "root", "secret");
            Statement stmt = c.createStatement();
            String sql = "SELECT * FROM accounts";
            ResultSet result = stmt.executeQuery(sql);
            System.out.println(result);
            result.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return "Pong";
    }
}

@RestController
@RequestMapping("/users")
class UserRestController {
    @GetMapping("/{userId}")
    public String getUserName(@PathVariable Long userId) {
        return "Hello User " + userId;
    }
}
