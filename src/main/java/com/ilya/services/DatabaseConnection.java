package com.ilya.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConnection {

    private final Connection connection;


    public DatabaseConnection(@Value("${jdbc.url}") String URL,
                              @Value("${jdbc.username}") String hostName,
                              @Value("${jdbc.password}") String hostPassword) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL, hostName, hostPassword);
    }

    @PreDestroy
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.exit(1);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
