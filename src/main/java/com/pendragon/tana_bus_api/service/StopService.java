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
    
    public List<Stop> getAllStops() throws SQLException{
        return repository.getAllStops();
    }
}
