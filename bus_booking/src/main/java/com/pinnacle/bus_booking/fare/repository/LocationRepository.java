package com.pinnacle.bus_booking.fare.repository;
//import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinnacle.bus_booking.fare.model.Locations;

// public interface LocationRepository extends MongoRepository<Locations ,String> {

// }

public interface LocationRepository extends JpaRepository<Locations ,Long> {

}


