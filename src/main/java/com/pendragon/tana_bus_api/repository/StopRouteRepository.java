package com.pendragon.tana_bus_api.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pendragon.tana_bus_api.entity.StopRoute;

@Repository
public class StopRouteRepository {
    private Connection connection;

    public StopRouteRepository(Connection connection) {
        this.connection = connection;
    }

    public List<StopRoute> getAllStopRoutes() throws SQLException {
        List<StopRoute> allStopRoutes = new ArrayList<>();
        String sql = "SELECT * FROM stop_route ORDER BY stop_route_id ASC";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                allStopRoutes.add(new StopRoute(
                        result.getInt("stop_route_id"),
                        result.getInt("stop_id"),
                        result.getInt("route_id")
                        ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allStopRoutes;
    }

    public StopRoute getStopRouteById(int id) throws SQLException {
        String sql = "SELECT * FROM stop_route WHERE stop_route_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                return new StopRoute(
                        result.getInt("stop_route_id"),
                        result.getInt("stop_id"),
                        result.getInt("route_id")
                        );
                    }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Object> deleteStopRoute(StopRoute stopRouteToDelete) throws SQLException {
        String sql = "DELETE FROM stop_route WHERE stop_route_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, stopRouteToDelete.getStop_route_id());
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted == 0) {
                return List.of("StopRoute id: " + stopRouteToDelete.getStop_route_id() + " not found", stopRouteToDelete);
            }
        }
        return List.of("StopRoute id: " + stopRouteToDelete.getStop_route_id() + " deleted successfully !", stopRouteToDelete);
    }

    public void addStopRoutes(StopRoute stopRouteToAdd) throws SQLException {
        String sql = "INSERT INTO stop_route (stop_route_id, stop_id, route_id) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, stopRouteToAdd.getStop_route_id());
            preparedStatement.setInt(2, stopRouteToAdd.getStop_id());
            preparedStatement.setInt(3, stopRouteToAdd.getRoute_id());

            preparedStatement.executeUpdate();

        }
    }

    public void updateStopRoutes(StopRoute stopRouteToUpdate) throws SQLException {
        String sql = "UPDATE stopRoute SET stop_id = ? , route_id = ? WHERE stop_route_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, stopRouteToUpdate.getStop_id());
            preparedStatement.setInt(2, stopRouteToUpdate.getRoute_id());
            preparedStatement.setInt(3, stopRouteToUpdate.getStop_route_id());
            
            preparedStatement.executeUpdate();

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted == 0) {
                String sql_add_id = "INSERT INTO stop_route (stop_route_id, stop_id, route_id) VALUES (?, ?, ?)";

                try (PreparedStatement preparedStatement_id = connection.prepareStatement(sql_add_id)) {
                    preparedStatement_id.setInt(1, stopRouteToUpdate.getStop_route_id());
                    preparedStatement_id.setInt(2, stopRouteToUpdate.getStop_id());
                    preparedStatement_id.setInt(3, stopRouteToUpdate.getRoute_id());
 
                    preparedStatement_id.executeUpdate();
                }
            }
        }

    }
}