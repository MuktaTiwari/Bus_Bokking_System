package com.pinnacle.bus_booking.fare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.mongodb.repository.MongoRepository;

import com.pinnacle.bus_booking.fare.model.Fare;

// public interface FareRepository extends MongoRepository<Fare, String>  {

// }

public interface FareRepository extends JpaRepository<Fare, Long>  {

}
