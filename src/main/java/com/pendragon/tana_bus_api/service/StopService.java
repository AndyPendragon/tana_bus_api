package com.pendragon.tana_bus_api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pendragon.tana_bus_api.entity.Stop;
import com.pendragon.tana_bus_api.repository.StopRepository;

@Service
public class StopService {
    private StopRepository repository;

    public StopService(StopRepository repository) {
        this.repository = repository;
    }

    public List<Stop> getAllStops() throws SQLException {
        return repository.getAllStops();
    }

    public Object getStopById(int id) throws SQLException {
        return repository.getStopById(id);
    }

    public Object deleteStop(Stop stop) throws SQLException {
        return repository.deleteStop(stop);
    }

    public Stop addStops(Stop stop) throws SQLException {
        this.repository.addStops(stop);
        return stop;
    }

    public Stop updateStops(Stop stop) throws SQLException {
        this.repository.updateStops(stop);
        return stop;
    }
}
