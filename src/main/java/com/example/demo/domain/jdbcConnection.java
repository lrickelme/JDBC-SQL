package com.example.demo.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcConnection {
    public static final String URL = "jdbc:postgresql://ep-cold-sound-a4vs4bc3-pooler.us-east-1.aws.neon.tech:5432/verceldb?sslmode=require";
    public static final String USER = "default";
    public static final String PASSWORD = "NgadzAIYS36i";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
