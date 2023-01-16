package com.example.simple_spring.service;

import com.example.simple_spring.Repository.OrderRepository;
import com.example.simple_spring.exception.OrderNotFoundException;
import com.example.simple_spring.model_entity.Order;
import com.example.simple_spring.model_entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final ProductService productService;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerService customerService, ProductService productService) {
        this.orderRepository = orderRepository;

        this.customerService = customerService;
        this.productService = productService;
    }
    public List<Order> findAllOrder(){
        return orderRepository.findAll();
    }
    public Order findOrderById (String id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order by id" + id + "not found"));
    }
    public Order addOrder(Order order){

        String x = order.getCustomer().getId();
        order.setCustomer(customerService.findCustomerById(x));

        List<Product> listP = order.getProductList();
        List<Product> listW = new ArrayList<>();

        for (Product product : listP) {
            System.out.print(product.getId());
            String PId = product.getId();
            Product w =productService.findProductById(PId);
            listW.add(w);
            order.setProductList(listW);

        }
        //
        return  orderRepository.save(order);
    }

    public void deleteOrder (String id) {orderRepository.deleteById(id);}


    public Order updateOrder (Order order){

        return orderRepository.save(order);
    }
}
