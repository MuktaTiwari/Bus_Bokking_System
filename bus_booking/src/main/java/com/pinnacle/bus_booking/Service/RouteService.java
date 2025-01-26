package com.pinnacle.bus_booking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinnacle.bus_booking.Repository.RouteRepository;
import com.pinnacle.bus_booking.model.Route;


@Service
public class RouteService {

    @Autowired
    private RouteRepository repo;


    public Route saveRoute(Route route) {

        return repo.save(route);
    }

    public List<Route> getAllRoute() {
        return repo.findAll();
    }

    public Route updateRoute(int id, Route route) {
        if(repo.existsById(id)){
            route.setId(id);
            return repo.save(route);
        }
        return null;
    }

    public void deleteRoute(int id) {

        repo.deleteById(id);
    }
    
}
