package com.pinnacle.bus_booking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pinnacle.bus_booking.fare.model.Locations;
import com.pinnacle.bus_booking.fare.repository.LocationDAO;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/location")

public class LocationController {
	
	@Autowired
	private LocationDAO dao;
	
    @GetMapping
    public ResponseEntity<List<Locations>> getAllLocations() {
        List<Locations> locations = dao.getAllLocation();
        return ResponseEntity.ok(locations); 
    }
	
	@PostMapping
	public ResponseEntity<String> saveLocation(@RequestBody Locations loc){
		try{
			dao.saveLcoation(loc);
			return ResponseEntity.ok("Locations created successfully");
		}
		catch(Exception e){
			return ResponseEntity.internalServerError().body("Failed to save the  location." );
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLocation(@PathVariable int id){
		int rowDeleted = dao.deleteLocation(id);
		if(rowDeleted > 0){
			return ResponseEntity.ok("Location deleted Successfully");
		}
		else{
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updtaeLocation(@PathVariable int id, @RequestBody Locations locations) {
		locations.setId(id);
		dao.updtaeLocation(locations);
		return ResponseEntity.ok("Location update successfully");
	}
}
