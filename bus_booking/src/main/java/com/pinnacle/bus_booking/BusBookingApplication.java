package com.pinnacle.bus_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.pinnacle.bus_booking.Repository")
public class BusBookingApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusBookingApplication.class, args);
    }
}
