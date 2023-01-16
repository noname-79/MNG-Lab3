package com.example.simple_spring.model_entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
@Document
@Data

public class Order {
    @MongoId
    private String id;
    private double cost;
    private Address addressDeliver;
    private Customer customer;
    List<Product> productList;

    public Order(double cost, Address addressDeliver, Customer customer, List<Product> productList) {
        this.cost = cost;
        this.addressDeliver = addressDeliver;
        this.customer = customer;
        this.productList = productList;
    }
}
