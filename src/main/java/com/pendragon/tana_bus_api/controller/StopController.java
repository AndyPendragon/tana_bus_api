package com.pendragon.tana_bus_api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/stop")
    public List<Stop> getAllStops() throws SQLException{
        return service.getAllStops();
    }

    @PostMapping("/stop")
    public Stop addStops(@RequestBody Stop stop) {
        return service.addStops(stop);
    }
}
