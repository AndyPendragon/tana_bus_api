package com.pendragon.tana_bus_api.repository;

public class DBConfiguration {
    public final static String URL = "jdbc:postgresql://localhost:5432/tana_bus_api";
    public final static String USERNAME = System.getenv("DB_USERNAME");
    public final static String PASSWORD = System.getenv("DB_PASSWORD");
}
