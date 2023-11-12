package com.mughilan16.simplebank.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final String DATABASE_URL = "jdbc:postgresql://localhost:5432/simple_bank";
    private final String DATABASE_USERNAME = "root";
    private final String DATABASE_PASSWORD = "secret";
    private AccountRespository db;

    AccountController() {
        db = new AccountRespository(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
    }

    @PostMapping("/")
    public String createAccount(@JsonFormat Account account) {
        try {
            return account.owner;
        } catch (Exception e) {
        }
        return "Hello";
    }

    @GetMapping("/{accountId}")
    public String getAccount(@PathVariable Integer accountId) {
        try {
            Account account = db.GetAccount(accountId);
            return account.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }
}
