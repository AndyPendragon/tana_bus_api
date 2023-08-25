package com.pendragon.tana_bus_api.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.pendragon.tana_bus_api.entity.Location;

@Repository
public class LocationRepository {
    private Connection connection;

    public LocationRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Location> getAllLocations() throws SQLException {
        List<Location> allLocations = new ArrayList<>();
        String sql = "SELECT * FROM location ORDER BY location_id ASC";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                allLocations.add(new Location(
                        result.getInt("location_id"),
                        result.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allLocations;
    }

    public Object getLocationById(int id) throws SQLException {
        String sql = "SELECT * FROM location WHERE location_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                return new Location(
                        result.getInt("location_id"),
                        result.getString("name"));
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    public Object deleteLocation(Location locationToDelete) throws SQLException {
        String sql = "DELETE FROM location WHERE location_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, locationToDelete.getLocation_id());
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted == 0) {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
            
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    public Object addLocations(Location locationToAdd) throws SQLException {
        String sql_add_id = "INSERT INTO location (location_id, name) VALUES (?, ?)";

        try (PreparedStatement preparedStatement_id = connection.prepareStatement(sql_add_id)) {
            preparedStatement_id.setInt(1, locationToAdd.getLocation_id());
            preparedStatement_id.setString(2, locationToAdd.getName());

            preparedStatement_id.executeUpdate();

            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
    }

    public Object updateLocations(Location locationToUpdate) throws SQLException {
        String sql = "UPDATE location SET name = ? WHERE location_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, locationToUpdate.getName());
            preparedStatement.setInt(2, locationToUpdate.getLocation_id());

            preparedStatement.executeUpdate();

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted == 0) {
                String sql_add_id = "INSERT INTO location (location_id, name) VALUES (?, ?)";

                try (PreparedStatement preparedStatement_id = connection.prepareStatement(sql_add_id)) {
                    preparedStatement_id.setInt(1, locationToUpdate.getLocation_id());
                    preparedStatement_id.setString(2, locationToUpdate.getName());
                    
                    preparedStatement_id.executeUpdate();

                    return new ResponseEntity<Void>(HttpStatus.CREATED);
                }
            }
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

    }
}