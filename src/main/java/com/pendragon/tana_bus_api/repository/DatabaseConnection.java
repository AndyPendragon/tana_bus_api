package com.pendragon.tana_bus_api.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConnection {
    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DBConfiguration.URL, DBConfiguration.USERNAME, DBConfiguration.PASSWORD);
    }
}
