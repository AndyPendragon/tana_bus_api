package com.pendragon.tana_bus_api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pendragon.tana_bus_api.entity.Location;
import com.pendragon.tana_bus_api.service.LocationService;

@RestController
public class LocationController {
    private LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping("/locations")
    public List<Location> getAllLocations() throws SQLException {
        return service.getAllLocations();
    }

    @GetMapping("/location/{id}")
    public Object getLocationById(@PathVariable int id) throws SQLException {
        return service.getLocationById(id);
    }

    @DeleteMapping("/location")
    public Object deleteLocation(@RequestBody Location location) throws SQLException {
        return service.deleteLocation(location);
    }

    @PostMapping("/location")
    public Location addLocations(@RequestBody Location location) throws SQLException {
        return service.addLocations(location);
    }

    @PutMapping("/location")
    public Location updateLocations(@RequestBody Location location) throws SQLException {
        return service.updateLocations(location);
    }
}
