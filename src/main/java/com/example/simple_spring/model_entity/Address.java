package com.example.simple_spring.model_entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor

public class Address {
    @MongoId
    private String id;
    private String city;
    private String country;
    private String flatNumber;
    private String streetName;

}
