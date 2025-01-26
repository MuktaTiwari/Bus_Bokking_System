package com.pinnacle.bus_booking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinnacle.bus_booking.Repository.FareRepository;
import com.pinnacle.bus_booking.model.Fare;

@Service
public class FareService {

    @Autowired
    private FareRepository repo;


    public Fare saveFare(Fare fare) {
        return repo.save(fare);
    }

    public List<Fare> getAllFares() {
        return repo.findAll();
    }

    public void deleteFare(String id) {
        repo.deleteById(id);
    }

    public Fare updateFare(String id, Fare fare) {
         if(repo.existsById(id)){
            fare.setId(id);
            return repo.save(fare);
         }
         return null ;
    }
    
}
