package com.pinnacle.bus_booking.fare.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinnacle.bus_booking.fare.model.Fare;
import com.pinnacle.bus_booking.fare.repository.FareRepository;
import com.pinnacle.bus_booking.fare.service.FareService;


@Service
public class FareImplementation implements FareService{
	
	@Autowired
	private FareRepository repo;

	@Override
	public Fare saveFares(Fare fare) {
		return repo.save(fare);
	}

	@Override
	public List<Fare> getAllFares() {
		
		return repo.findAll();
	}

	@Override
	public Optional<Fare> updateFare(Long id, Fare fare) {
	    return repo.findById(id).map(existingFare -> {
	        existingFare.setRoute(fare.getRoute());
	        existingFare.setFromLocation(fare.getFromLocation());
	        existingFare.setToLocation(fare.getToLocation());
	        existingFare.setPrice(fare.getPrice());
	        return repo.save(existingFare);
	    });
	}

	@Override
	public void deleteFare(Long id) {
		repo.deleteById(id);
	}


}
