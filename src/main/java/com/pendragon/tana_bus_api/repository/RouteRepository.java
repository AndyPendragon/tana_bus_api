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

import com.pendragon.tana_bus_api.entity.Route;

@Repository
public class RouteRepository {
    private Connection connection;

    public RouteRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Route> getAllRoutes() throws SQLException {
        List<Route> allRoutes = new ArrayList<>();
        String sql = "SELECT * FROM route ORDER BY route_id ASC";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                allRoutes.add(new Route(
                        result.getInt("route_id"),
                        result.getString("name"),
                        result.getString("company"),
                        result.getInt("direction_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allRoutes;
    }

    public Object getRouteById(int id) throws SQLException {
        String sql = "SELECT * FROM route WHERE route_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                return new Route(
                        result.getInt("route_id"),
                        result.getString("name"),
                        result.getString("company"),
                        result.getInt("direction_id"));
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }

    public Object searchRouteByName(String q) throws SQLException {
        List<Route> allRoutes = new ArrayList<>();
        String sql = "SELECT * FROM route WHERE name ILIKE ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + q + "%");
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                allRoutes.add(new Route(
                        result.getInt("route_id"),
                        result.getString("name"),
                        result.getString("company"),
                        result.getInt("direction_id")));
            }
        }
        if (allRoutes.isEmpty()) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return allRoutes;
    }

    public Object deleteRoute(Route routeToDelete) throws SQLException {
        String sql = "DELETE FROM route WHERE route_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, routeToDelete.getRoute_id());
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted == 0) {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    public Object addRoutes(Route routeToAdd) throws SQLException {
        String sql = "INSERT INTO route (name, company, direction_id) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, routeToAdd.getName());
            preparedStatement.setString(2, routeToAdd.getCompany());
            preparedStatement.setInt(3, routeToAdd.getDirection_id());

            preparedStatement.executeUpdate();

            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
    }

    public Object updateRoutes(Route routeToUpdate) throws SQLException {
        String sql = "UPDATE route SET name = ? , company = ? , direction_id = ? WHERE route_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, routeToUpdate.getName());
            preparedStatement.setString(2, routeToUpdate.getCompany());
            preparedStatement.setInt(3, routeToUpdate.getDirection_id());
            preparedStatement.setInt(4, routeToUpdate.getRoute_id());

            preparedStatement.executeUpdate();

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted == 0) {
                String sql_add_id = "INSERT INTO route (route_id, name, company, direction_id) VALUES (?, ?, ?, ?)";

                try (PreparedStatement preparedStatement_id = connection.prepareStatement(sql_add_id)) {
                    preparedStatement_id.setInt(1, routeToUpdate.getRoute_id());
                    preparedStatement_id.setString(2, routeToUpdate.getName());
                    preparedStatement_id.setString(3, routeToUpdate.getCompany());
                    preparedStatement_id.setInt(4, routeToUpdate.getDirection_id());

                    preparedStatement_id.executeUpdate();

                    return new ResponseEntity<Void>(HttpStatus.CREATED);
                }
            }
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

    }
}