package com.mughilan16.simplebank.account;

public class Account {
    int id;
    String owner;
    int balance;
    String currency;
    public Account(int id, String owner, int balance, String currency) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.currency = currency;
    }
}
