package com.example.simple_spring.model_entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Data

public class Product {
    @MongoId
    private String id;
    private String name;
    private double price;
    private double size;
    private boolean availability;

    public Product(String name, double price, double size, boolean availability) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.availability = availability;
    }
}
