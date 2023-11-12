package com.mughilan16.simplebank.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

/**
 * AccountRespository
 */
@Repository
public class AccountRespository {
    private String username;
    private String url;
    private String password;

    public AccountRespository(String url, String username, String password) {
        this.username = username;
        this.password = password;
        this.url = url;
    }

    final private Connection connectDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    final public Account GetAccount(int id) throws Exception {
        Connection connection;
        Account account;
        connection = connectDB();
        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM accounts WHERE id = " + id;
        ResultSet result = stmt.executeQuery(sql);
        if (result.next()) {
            account = new Account(result.getInt("id"), result.getString("owner"), result.getInt("balance"),
                    result.getString("currency"));
        } else {
            throw new Exception("Row not found");
        }
        result.close();
        stmt.close();
        connection.close();
        return account;
    }
}
