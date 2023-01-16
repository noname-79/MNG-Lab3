package com.example.simple_spring.Repository;


import com.example.simple_spring.model_entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,String> {
}
