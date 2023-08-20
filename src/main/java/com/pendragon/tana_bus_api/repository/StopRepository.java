package com.pendragon.tana_bus_api.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pendragon.tana_bus_api.entity.Stop;

@Repository
public class StopRepository {
    private Connection connection;
    
    public StopRepository(Connection connection) {
        this.connection = connection;
    }
    
    public List<Stop> getAllStops() throws SQLException {
        List<Stop> allStops = new ArrayList<>();
        String sql = "SELECT * FROM stop";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                allStops.add(new Stop(
                    result.getInt("stop_id"), 
                    result.getString("name"), 
                    result.getFloat("longitude"), 
                    result.getFloat("latitude")
                ));            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allStops;
    }
}