package com.equintanar.customers.controller;

import com.equintanar.customers.entity.Customer;
import com.equintanar.customers.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }
}
