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

import com.pendragon.tana_bus_api.entity.StopRoute;
import com.pendragon.tana_bus_api.service.StopRouteService;

@RestController
public class StopRouteController {
    private StopRouteService service;

    public StopRouteController(StopRouteService service) {
        this.service = service;
    }

    @GetMapping("/stopRoutes")
    public List<StopRoute> getAllStopRoutes() throws SQLException {
        return service.getAllStopRoutes();
    }

    @GetMapping("/stopRoute/{id}")
    public StopRoute getStopRouteById(@PathVariable int id) throws SQLException {
        return service.getStopRouteById(id);
    }

    @DeleteMapping("/stopRoute")
    public List<Object> deleteStopRoute(@RequestBody StopRoute stopRoute) throws SQLException {
        return service.deleteStopRoute(stopRoute);
    }

    @PostMapping("/stopRoute")
    public StopRoute addStopRoutes(@RequestBody StopRoute stopRoute) throws SQLException {
        return service.addStopRoutes(stopRoute);
    }

    @PutMapping("/stopRoute")
    public StopRoute updateStopRoutes(@RequestBody StopRoute stopRoute) throws SQLException {
        return service.updateStopRoutes(stopRoute);
    }
}
