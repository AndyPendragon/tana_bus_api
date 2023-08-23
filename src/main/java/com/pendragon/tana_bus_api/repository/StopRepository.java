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
                        result.getInt("location_id"),
                        result.getInt("next_stop_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allStops;
    }

    public Stop getStopById(int id) throws SQLException {
        String sql = "SELECT * FROM stop WHERE stop_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                return new Stop(
                        result.getInt("stop_id"),
                        result.getString("name"),
                        result.getFloat("longitude"),
                        result.getFloat("latitude"),
                        result.getInt("location_id"),
                        result.getInt("next_stop_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteStopById(int id) throws SQLException {
        String sql = "DELETE FROM stop WHERE stop_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted == 0) {
                return "Stop id: " + id + " was not found";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Stop id: " + id + " was deleted successfully !";
    }

    public void addStops(Stop stopToAdd) throws SQLException {
        String sql = "INSERT INTO stop (name, longitude, latitude, location_id, next_stop_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, stopToAdd.getName());
            preparedStatement.setDouble(2, stopToAdd.getLongitude());
            preparedStatement.setDouble(3, stopToAdd.getLatitude());
            preparedStatement.setInt(4, stopToAdd.getLocation_id());
            preparedStatement.setInt(5, stopToAdd.getNext_stop_id());

            preparedStatement.executeUpdate();
        }
    }

    public void updateStops(Stop stopToUpdate) throws SQLException {
        String sql = "UPDATE stop SET name = ?, longitude = ?, latitude = ?, location_id = ?, next_stop_id = ? WHERE stop_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, stopToUpdate.getName());
            preparedStatement.setDouble(2, stopToUpdate.getLongitude());
            preparedStatement.setDouble(3, stopToUpdate.getLatitude());
            preparedStatement.setInt(4, stopToUpdate.getLocation_id());
            preparedStatement.setInt(5, stopToUpdate.getNext_stop_id());
            preparedStatement.setInt(6, stopToUpdate.getStop_id());

            preparedStatement.executeUpdate();

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted == 0) {
                String sql_add_id = "INSERT INTO stop (stop_id, name, longitude, latitude, location_id, next_stop_id) VALUES (?, ?, ?, ?, ?, ?)";

                try (PreparedStatement preparedStatement_id = connection.prepareStatement(sql_add_id)) {
                    preparedStatement_id.setInt(1, stopToUpdate.getStop_id());
                    preparedStatement_id.setString(2, stopToUpdate.getName());
                    preparedStatement_id.setDouble(3, stopToUpdate.getLongitude());
                    preparedStatement_id.setDouble(4, stopToUpdate.getLatitude());
                    preparedStatement_id.setInt(5, stopToUpdate.getLocation_id());
                    preparedStatement_id.setInt(6, stopToUpdate.getNext_stop_id());

                    preparedStatement_id.executeUpdate();
                }
            }
        }

    }
}