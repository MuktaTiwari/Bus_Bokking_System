package com.pinnacle.bus_booking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinnacle.bus_booking.fare.model.Fare;
import com.pinnacle.bus_booking.fare.repository.FareDAO;

@RestController
@RequestMapping("/fare")
public class FareController {

    @Autowired
    private FareDAO dao;

    //Get the list of fares
    @GetMapping
    public ResponseEntity<List<Fare>> getAllFares() {
        return ResponseEntity.ok(dao.getAllFares());
    }

    @PostMapping
    public ResponseEntity<String> saveFare(@RequestBody Fare fare) { 
        try {
            dao.saveFare(fare); 
            return ResponseEntity.ok("Fare saved successfully"); 
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to save fare. Please check server logs."); 
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFare(@PathVariable int id){
        int rowDeleted = dao.deleteFare(id);
        if(rowDeleted > 0){
            return ResponseEntity.ok("Fare deleted successfully.");
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFare(@PathVariable int id, @RequestBody Fare fare){
        fare.setId(id);
        dao.updateFare(fare);
        return ResponseEntity.ok("Fare updated Successfully");
    }
}
