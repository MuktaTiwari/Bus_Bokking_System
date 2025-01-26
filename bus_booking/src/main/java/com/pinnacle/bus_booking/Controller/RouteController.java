package com.pinnacle.bus_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinnacle.bus_booking.Service.RouteService;
import com.pinnacle.bus_booking.model.Route;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;


    @PostMapping
    public Route saveRoute(@RequestBody Route route){
        return routeService.saveRoute(route);
    }

    @GetMapping
    public List<Route> getAllRoute(){
        return routeService.getAllRoute();
        
    }

    @PutMapping("/{id}")
    public Route updateRoute(@PathVariable int id, @RequestBody Route route){

        return routeService.updateRoute(id, route);
    }

    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable int id){
        routeService.deleteRoute(id);
    }
    
}
