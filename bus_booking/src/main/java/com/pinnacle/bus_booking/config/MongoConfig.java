package com.pinnacle.bus_booking.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.pinnacle.bus_booking.Repository")  // Corrected the basePackages value
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "bus_multi_database"; // Your MongoDB database name
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://username:password@cluster0.l0tqz.mongodb.net/bus_multi_database?retryWrites=true&w=majority");  // MongoDB URI
    }
}
