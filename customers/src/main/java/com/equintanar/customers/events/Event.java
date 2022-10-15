package com.equintanar.customers.events;

import lombok.Data;

import java.util.Date;

@Data
public class Event<T> {
    private String id;
    private Date date;
    private EventType eventType;
    private T data;
}
