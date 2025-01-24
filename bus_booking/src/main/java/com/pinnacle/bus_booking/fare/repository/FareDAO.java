package com.pinnacle.bus_booking.fare.repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pinnacle.bus_booking.fare.model.Fare;

@Repository
public class FareDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String saveFare(Fare fare) {
        
        String sql = "INSERT INTO fares (fromLocation, toLocation, route, price) VALUES (?, ?, ?, ?)";
        int rowsAffected = jdbcTemplate.update(sql, fare.getFromLocation(), fare.getToLocation(), fare.getRoute(), fare.getPrice());
        return rowsAffected > 0 ? "Fare save successfully" : "Failed to save fare";
    }
    public List<Fare> getAllFares(){
        String sql = "SELECT * FROM fares";
        return jdbcTemplate.query(sql, (rs, rowNum) ->{
            Fare fare = new Fare();
            fare.setId(rs.getInt("id"));
            fare.setFromLocation(rs.getString("fromLocation"));
            fare.setToLocation(rs.getString("toLocation"));
            fare.setRoute(rs.getString("route"));
            fare.setPrice(rs.getDouble("price"));
            return fare;

        });
    }

    public int deleteFare(int id){
        String sql = "DELETE FROM fares WHERE id = ?";
        return jdbcTemplate.update(sql,id);
    }
    public int updateFare(Fare fare) {
        String sql = "UPDATE fares SET fromLocation = ?, toLocation = ?,  route = ?, price = ? WHERE id = ?";
        return jdbcTemplate.update(sql, fare.getFromLocation(), fare.getToLocation(), fare.getRoute(), fare.getPrice(), fare.getId());
    }
}


