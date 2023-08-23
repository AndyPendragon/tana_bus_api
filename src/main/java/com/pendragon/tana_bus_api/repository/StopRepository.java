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
                        result.getFloat("latitude"),
                        result.getString("location_id"),
                        result.getInt("next_stop_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allStops;
    }

    public void addStops(Stop stopToAdd) throws SQLException{
        String sql = "INSERT INTO stop (name, longitude, latitude, location_id, next_stop_id)"+
            "VALUES (?,?,?,?,?);";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, stopToAdd.getName());
            statement.setDouble(2, stopToAdd.getLongitude());
            statement.setDouble(3, stopToAdd.getLatitude());
            statement.setString(4, stopToAdd.getLocation_id());
            statement.setInt(5, stopToAdd.getNext_stop_id());

            statement.executeUpdate();
        }
    }
}