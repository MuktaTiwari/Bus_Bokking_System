package com.pinnacle.bus_booking.fare.model;

import org.springframework.data.annotation.Id;  // Correct import for @Id
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;  // Correct import for @Field

@Document(collection = "Locations")
public class Locations {

    @Id
    private String id;  // MongoDB typically uses String for the _id field

    @Field("name")  // Using @Field to map the field to MongoDB if necessary
    private String name;

    // Getter and Setter for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
