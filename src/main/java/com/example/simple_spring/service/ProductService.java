package com.example.simple_spring.service;

import com.example.simple_spring.Repository.ProductRepository;
import com.example.simple_spring.exception.ProductNotFoundException;
import com.example.simple_spring.model_entity.Product;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }
    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }
    public Product findProductById (String id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product by id" + id + "not found"));
    }
    public Product addProduct(Product product){
        return  productRepository.save(product);
    }

    public void deleteProduct (String id) {productRepository.deleteById(id);}

    public Product updateProduct (Product produc){

        return productRepository.save(produc);
    }

}
