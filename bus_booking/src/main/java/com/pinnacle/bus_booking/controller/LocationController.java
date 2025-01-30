package com.pinnacle.bus_booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pinnacle.bus_booking.fare.model.Locations;
import com.pinnacle.bus_booking.fare.service.LocationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/all")
    public ResponseEntity<List<Locations>> getAllLocations() {
        List<Locations> locations = locationService.getAllLocation();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveLocation(@RequestBody Locations loc) {
        Locations saveLocation = locationService.saveLcoation(loc);
        return new ResponseEntity<>("Location created successfully with ID: " + saveLocation.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLocation(@PathVariable Long id, @RequestBody Locations loc) {
        Optional<Locations> updatedLocation = locationService.updateLocation(id, loc);
        return updatedLocation
                .map(l -> new ResponseEntity<>("Location updated", HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("Location not found", HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long id) {
        locationService.deleteLocations(id);
        return new ResponseEntity<>("Location deleted successfully", HttpStatus.NO_CONTENT);
    }
}
