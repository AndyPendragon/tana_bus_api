package com.pendragon.tana_bus_api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pendragon.tana_bus_api.entity.Location;
import com.pendragon.tana_bus_api.repository.LocationRepository;

@Service
public class LocationService {
    private LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> getAllLocations() throws SQLException {
        return repository.getAllLocations();
    }

    public Location getLocationById(int id) throws SQLException {
        return repository.getLocationById(id);
    }

    public List<Object> deleteLocation(Location location) throws SQLException {
        return repository.deleteLocation(location);
    }

    public Location addLocations(Location location) throws SQLException {
        this.repository.addLocations(location);
        return location;
    }

    public Location updateLocations(Location location) throws SQLException {
        this.repository.updateLocations(location);
        return location;
    }
}
