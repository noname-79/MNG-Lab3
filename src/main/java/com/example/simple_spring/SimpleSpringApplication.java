package com.example.simple_spring;

import com.example.simple_spring.Repository.ProductRepository;
import com.example.simple_spring.model_entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSpringApplication.class, args);
    }


//   @Bean
//   @Autowired
//   CommandLineRunner runner (ProductRepository repository){
//       return args -> {
//           Product product = new Product(
//                   "Koszulka",
//                   50,
//                   36,
//                   true
//           );
//           repository.insert(product);
//
//       };
   }
//
