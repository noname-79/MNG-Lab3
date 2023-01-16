package com.example.simple_spring.service;

import com.example.simple_spring.Repository.CustomerRepository;
import com.example.simple_spring.Repository.OrderRepository;
import com.example.simple_spring.Repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.graalvm.polyglot.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.graalvm.polyglot.PolyglotException;


@Slf4j
@Service
public class ScriptService {
    private final CustomerService customerService;
    private final OrderService orderService;
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public ScriptService(CustomerService customerService, OrderService orderService, ProductService productService, ProductRepository productRepository, OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.productService = productService;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public String exec(String script) {
        try (Context context = Context.newBuilder("js")
                .allowAllAccess(true)
                .build()) {


            var bindings =context.getBindings("js");
            bindings.putMember("PS", productService);
            bindings.putMember("CS", customerService);
            bindings.putMember("OS", orderService);
            bindings.putMember("PR", productRepository);
            bindings.putMember("CR", customerRepository);
            bindings.putMember("OR", orderRepository);
            return context.eval("js", script).toString();

        } catch (PolyglotException e) {
            log.error("Error executing", e);
            return e.getMessage() + "\n" + e.getSourceLocation().toString();
        }
    }
}