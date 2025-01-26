package com.pinnacle.bus_booking.Controller;

import com.pinnacle.bus_booking.Service.LocationService;
import com.pinnacle.bus_booking.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public Locations createLocation(@RequestBody Locations location) {
        return locationService.saveLocation(location);
    }

    @GetMapping
    public List<Locations> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public Locations getLocationById(@PathVariable int id) {
        Optional<Locations> location = locationService.getLocationById(id);
        return location.orElse(null); // Handle accordingly if not found
    }

    @PutMapping("/{id}")
    public Locations updateLocation(@PathVariable int id, @RequestBody Locations locationDetails) {
        return locationService.updateLocation(id, locationDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable int id) {
        locationService.deleteLocation(id);
    }
}
