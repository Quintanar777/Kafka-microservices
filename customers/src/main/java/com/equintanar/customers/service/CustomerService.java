package com.equintanar.customers.service;

import com.equintanar.customers.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class CustomerService {

    private final CustomerEventService customerEventService;

    public Customer save(Customer customer) {
        log.info("Received: {}", customer);
        this.customerEventService.publish(customer);
        return customer;
    }
}
