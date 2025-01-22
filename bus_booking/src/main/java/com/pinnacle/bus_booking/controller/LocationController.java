package com.pinnacle.bus_booking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinnacle.bus_booking.fare.model.Locations;
import com.pinnacle.bus_booking.fare.service.LocationService;

@RestController
@RequestMapping("/location")

public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/all")
	public List<Locations>getAllLocations(){
		return locationService.getAllLocation();
		
	}
	
	
	@PostMapping("/save")
	public String saveLocation(@RequestBody Locations loc){
		Locations saveLocation = locationService.saveLcoation(loc);
		return "Locations created successfully with ID: " + saveLocation.getId();

	}
	
	
	@PutMapping("/{id}")
	public String updateLocation(@PathVariable Long id, @RequestBody Locations loc) {
	    Optional<Locations> updateLocation = locationService.updateLocation(id, loc);
	    return updateLocation
	            .map(l -> ("Location Updated"))
	            .orElseGet(() -> ("Location not Found"));
	}
	
	
	@DeleteMapping("/{id}")
    public String deleteLocations(@PathVariable Long id) {
        locationService.deleteLocations(id);
        return "Locations deleted successfully";
    }

}
