package com.pinnacle.bus_booking.fare.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinnacle.bus_booking.fare.model.Locations;
import com.pinnacle.bus_booking.fare.repository.LocationRepository;
import com.pinnacle.bus_booking.fare.service.LocationService;


@Service
public class LocationImpl implements LocationService{
	
	@Autowired 
	private LocationRepository repo;
	

	@Override
	public List<Locations> getAllLocation() {
		
		return repo.findAll();
	}


	@Override
	public Locations saveLcoation(Locations loc) {
		return repo.save(loc);
	}


	@Override
	public Optional<Locations> updateLocation(Long id, Locations loc) {
	    return repo.findById(id).map(existingLocations -> {
	        existingLocations.setName(loc.getName());
	        return repo.save(existingLocations); // Save and return the updated entity
	    });
	}


	@Override
	public void deleteLocations(Long id) {
		repo.deleteById(id);
	}

}



