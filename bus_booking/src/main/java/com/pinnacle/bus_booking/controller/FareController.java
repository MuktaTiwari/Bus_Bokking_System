package com.pinnacle.bus_booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pinnacle.bus_booking.fare.model.Fare;
import com.pinnacle.bus_booking.fare.service.FareService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fare")
public class FareController {

    @Autowired
    private FareService fareService;

    @GetMapping("/all")
    public ResponseEntity<List<Fare>> getAllFares() {
        List<Fare> fares = fareService.getAllFares();
        return new ResponseEntity<>(fares, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveFare(@RequestBody Fare fare) {
        Fare createdFare = fareService.saveFares(fare);
        return new ResponseEntity<>("Fare saved successfully with ID: " + createdFare.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFare(@PathVariable Long id, @RequestBody Fare fare) {
        Optional<Fare> updatedFare = fareService.updateFare(id, fare);
        return updatedFare
                .map(f -> new ResponseEntity<>("Fare updated successfully", HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("Fare not found", HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFare(@PathVariable Long id) {
        fareService.deleteFare(id);
        return new ResponseEntity<>("Fare deleted successfully", HttpStatus.NO_CONTENT);
    }
}
