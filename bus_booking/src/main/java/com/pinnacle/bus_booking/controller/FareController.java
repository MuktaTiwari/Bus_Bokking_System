package com.pinnacle.bus_booking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinnacle.bus_booking.fare.model.Fare;
import com.pinnacle.bus_booking.fare.service.FareService;

@RestController
@RequestMapping("/fare")
public class FareController {

    @Autowired
    private FareService fareService;

    @GetMapping("/all")
    public List<Fare> getAllFares() {
        return fareService.getAllFares();
    }

    @PostMapping("/save")
    public String saveFare(@RequestBody Fare fare) {
        Fare createdFare = fareService.saveFares(fare);
        return "Fare Save successfully with ID: " + createdFare.getId();
    }

    @PutMapping("/{id}")
    public String updateFare(@PathVariable String id, @RequestBody Fare fare) {
        Optional<Fare> updatedFare = fareService.updateFare(id, fare);
        return updatedFare
                .map(f -> "Fare updated successfully")
                .orElseGet(() -> "Fare not found");
    }

    @DeleteMapping("/{id}")
    public String deleteFare(@PathVariable String id) {
        fareService.deleteFare(id);
        return "Fare deleted successfully";
    }
}
