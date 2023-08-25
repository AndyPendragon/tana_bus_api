package com.pendragon.tana_bus_api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pendragon.tana_bus_api.entity.StopRoute;
import com.pendragon.tana_bus_api.repository.StopRouteRepository;

@Service
public class StopRouteService {
    private StopRouteRepository repository;

    public StopRouteService(StopRouteRepository repository) {
        this.repository = repository;
    }

    public List<StopRoute> getAllStopRoutes() throws SQLException {
        return repository.getAllStopRoutes();
    }

    public StopRoute getStopRouteById(int id) throws SQLException {
        return repository.getStopRouteById(id);
    }

    public List<Object> deleteStopRoute(StopRoute stopRoute) throws SQLException {
        return repository.deleteStopRoute(stopRoute);
    }

    public StopRoute addStopRoutes(StopRoute stopRoute) throws SQLException {
        this.repository.addStopRoutes(stopRoute);
        return stopRoute;
    }

    public StopRoute updateStopRoutes(StopRoute stopRoute) throws SQLException {
        this.repository.updateStopRoutes(stopRoute);
        return stopRoute;
    }
}
