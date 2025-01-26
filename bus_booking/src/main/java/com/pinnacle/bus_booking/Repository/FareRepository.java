package com.pinnacle.bus_booking.Repository;

import com.pinnacle.bus_booking.model.Fare;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FareRepository extends MongoRepository<Fare , String>{
    
}
