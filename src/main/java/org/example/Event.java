package org.example;

import java.time.LocalDateTime;
import java.util.List;

public class Event {
    private String title;
    private String Description;
    private float unitPrice;
    private LocalDateTime startdate;
    private LocalDateTime validUnit;
    private List<Ticket> tickets;
    public Event(String title, float unitPrice, Theatre theatre){
        this.title = title;
        this.unitPrice = unitPrice;
    }

    public List<Ticket> reserveTicket(int noOfTickets){

    }
}
