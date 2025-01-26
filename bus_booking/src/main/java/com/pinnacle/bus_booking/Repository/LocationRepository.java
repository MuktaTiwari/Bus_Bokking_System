package com.pinnacle.bus_booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinnacle.bus_booking.model.Locations;


@Repository("locationRepository")
public interface LocationRepository extends JpaRepository<Locations, Integer> {
}