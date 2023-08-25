package com.pendragon.tana_bus_api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pendragon.tana_bus_api.entity.Route;
import com.pendragon.tana_bus_api.repository.RouteRepository;

@Service
public class RouteService {
    private RouteRepository repository;

    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    public List<Route> getAllRoutes() throws SQLException {
        return repository.getAllRoutes();
    }

    public Object getRouteById(int id) throws SQLException {
        return repository.getRouteById(id);
    }

    public Object deleteRoute(Route route) throws SQLException {
        return repository.deleteRoute(route);
    }

    public Object addRoutes(Route route) throws SQLException {
        this.repository.addRoutes(route);
        return route;
    }

    public Object updateRoutes(Route route) throws SQLException {
        this.repository.updateRoutes(route);
        return route;
    }
}
