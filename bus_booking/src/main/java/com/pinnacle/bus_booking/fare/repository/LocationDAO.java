package com.pinnacle.bus_booking.fare.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pinnacle.bus_booking.fare.model.Locations;

@Repository
public class LocationDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Locations> getAllLocation() {
        String sql = "SELECT * FROM locations";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Locations.class));
    }

    public String saveLcoation(Locations loc) {
        String sql = "INSERT INTO locations(name) VALUES(?)";
        int rowsAffected = jdbcTemplate.update(sql, loc.getName());
        return rowsAffected > 0 ? "Lcoation Saved SuccessFully": "Failed to save location";
    }

    public int deleteLocation(int id) {
        String sql = "DELETE FROM locations WHERE id = ?";
        return jdbcTemplate.update(sql,id);
    }

    public int updtaeLocation(Locations locations) {
        String sql = "UPDATE locations SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, locations.getName(), locations.getId());

    }
    
}
