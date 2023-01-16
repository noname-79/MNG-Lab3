package com.example.simple_spring.model_entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Data
public class Customer {
    @MongoId
    private String id;
    private String firstName;
    private String lastName;
    private Address address;
    private int phoneNumber;
    private String email;
    private String sex;

    public Customer(String firstName, String lastName, Address address, int phoneNumber, String email, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.sex = sex;
    }
}
