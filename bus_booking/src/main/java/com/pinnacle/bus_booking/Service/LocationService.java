package com.pinnacle.bus_booking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinnacle.bus_booking.Repository.LocationRepository;
import com.pinnacle.bus_booking.model.Locations;

@Service
public class LocationService {
    

    @Autowired
    private LocationRepository repo;

    public Locations saveLocation(Locations location) {
        return repo.save(location);
    }

    public List<Locations> getAllLocations() {
        return repo.findAll();
    }

    public void deleteLocation(int id) {
        repo.deleteById(id);
    }

    public Optional<Locations> getLocationById(int id) {
        return repo.findById(id);
    }

    public Locations updateLocation(int id, Locations locationDetails) {

        if(repo.existsById(id)){
            locationDetails.setId(id);
            return repo.save(locationDetails);
        }
        return null;

  }
    
}
