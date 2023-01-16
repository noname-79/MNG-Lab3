package com.example.simple_spring.Repository;

import com.example.simple_spring.model_entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {

}
