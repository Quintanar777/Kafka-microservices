package com.equintanar.customers.service;

import com.equintanar.customers.entity.Customer;
import com.equintanar.customers.events.CustomerCreatedEvent;
import com.equintanar.customers.events.Event;
import com.equintanar.customers.events.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CustomerEventService {

    private final KafkaTemplate<String, Event<?>> producer;

    private final String topicCustomer;

    @Autowired
    public CustomerEventService(KafkaTemplate<String, Event<?>> producer,
                                @Value("${topic.customer.name:customers}") String topicCustomer) {
        this.producer = producer;
        this.topicCustomer = topicCustomer;
    }

    public void publish(Customer customer) {
        CustomerCreatedEvent created = new CustomerCreatedEvent();
        created.setData(customer);
        created.setId(UUID.randomUUID().toString());
        created.setEventType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicCustomer, created);
    }
}
