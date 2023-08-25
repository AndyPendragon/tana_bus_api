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

import com.pendragon.tana_bus_api.entity.Route;
import com.pendragon.tana_bus_api.service.RouteService;

@RestController
public class RouteController {
    private RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @GetMapping("/routes")
    public List<Route> getAllRoutes() throws SQLException {
        return service.getAllRoutes();
    }

    @GetMapping("/route/{id}")
    public Object getRouteById(@PathVariable int id) throws SQLException {
        return service.getRouteById(id);
    }

    @DeleteMapping("/route")
    public Object deleteRoute(@RequestBody Route route) throws SQLException {
        return service.deleteRoute(route);
    }

    @PostMapping("/route")
    public Object addRoutes(@RequestBody Route route) throws SQLException {
        return service.addRoutes(route);
    }

    @PutMapping("/route")
    public Object updateRoutes(@RequestBody Route route) throws SQLException {
        return service.updateRoutes(route);
    }
}
