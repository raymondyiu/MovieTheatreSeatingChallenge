package org.example;

import java.time.LocalDateTime;

public class Event {
    private String title;
    private String Description;
    private float unitPrice;
    private LocalDateTime startdate;
    private LocalDateTime validUnit;
    public Event(String title, float unitPrice){
        this.title = title;
        this.unitPrice = unitPrice;
    }

    public List<Ticket> reserveTicket(int noOfTickets){

    }
}
