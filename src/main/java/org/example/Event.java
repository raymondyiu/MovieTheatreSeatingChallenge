package org.example;

import java.time.LocalDateTime;

public class Event {
    private String name;
    private String Description;
    private float unitPrice;
    private LocalDateTime startdate;
    private LocalDateTime validUnit;
    public Event(String name, float unitPrice){
        this.name = name;
        this.unitPrice = unitPrice;
    }

}
