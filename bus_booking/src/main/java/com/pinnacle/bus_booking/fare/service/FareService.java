package com.pinnacle.bus_booking.fare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pinnacle.bus_booking.fare.model.Fare;


@Service
public interface FareService {

	Fare saveFares(Fare fare);

	List<Fare> getAllFares();

	Optional<Fare> updateFare(String id, Fare fare);
	
	void deleteFare(String id);

}
