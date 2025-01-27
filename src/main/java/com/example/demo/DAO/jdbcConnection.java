package com.example.demo.DAO;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcConnection {
    private static final Dotenv dotenv = Dotenv.configure().load();

    public static final String URL = dotenv.get("DB_URL");
    public static final String USER = dotenv.get("DB_USERNAME");
    public static final String PASSWORD = dotenv.get("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}