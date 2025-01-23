package com.pinnacle.bus_booking.fare.service;

import java.util.List;
import java.util.Optional;

import com.pinnacle.bus_booking.fare.model.Locations;

public interface LocationService {


	List<Locations> getAllLocation();

	Locations saveLcoation(Locations loc);

    Optional<Locations> updateLocation(Long id, Locations loc); // Return Optional<Locations>

	void deleteLocations(Long id);

}
