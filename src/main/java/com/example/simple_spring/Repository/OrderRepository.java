package com.example.simple_spring.Repository;

import com.example.simple_spring.model_entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {
}
