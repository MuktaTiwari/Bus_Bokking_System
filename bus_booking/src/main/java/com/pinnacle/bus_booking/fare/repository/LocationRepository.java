package com.pinnacle.bus_booking.fare.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pinnacle.bus_booking.fare.model.Locations;

public interface LocationRepository extends MongoRepository<Locations ,String> {

}
