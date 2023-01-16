package com.example.simple_spring.service;

import com.example.simple_spring.Repository.CustomerRepository;
import com.example.simple_spring.exception.CustomerNotFoundException;
import com.example.simple_spring.model_entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }
    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }
    public Customer findCustomerById (String id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer by id" + id + "not found"));
    }
    public Customer addCustomer(Customer customer){
        return  customerRepository.save(customer);
    }

    public void deleteCustomer (String id) {customerRepository.deleteById(id);}

    public Customer updateCustomer (Customer customer){

        return customerRepository.save(customer);
    }
}
