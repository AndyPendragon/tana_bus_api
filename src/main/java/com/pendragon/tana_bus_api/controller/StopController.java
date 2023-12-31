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

import com.pendragon.tana_bus_api.entity.Stop;
import com.pendragon.tana_bus_api.service.StopService;

@RestController
public class StopController {
    private StopService service;

    public StopController(StopService service) {
        this.service = service;
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/stops")
    public List<Stop> getAllStops() throws SQLException {
        return service.getAllStops();
    }

    @GetMapping("/stop/{id}")
    public Object getStopById(@PathVariable int id) throws SQLException {
        return service.getStopById(id);
    }

    @DeleteMapping("/stop")
    public Object deleteStop(@RequestBody Stop stop) throws SQLException {
        return service.deleteStop(stop);
    }

    @PostMapping("/stop")
    public Stop addStops(@RequestBody Stop stop) throws SQLException {
        return service.addStops(stop);
    }

    @PutMapping("/stop")
    public Stop updateStops(@RequestBody Stop stop) throws SQLException {
        return service.updateStops(stop);
    }
}
