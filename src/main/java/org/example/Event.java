package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private String title;
    private String Description;
    private double unitPrice;
    Theatre theatre;
    private List<Ticket> tickets;
    public Event(String title, String eventDate, String eventTime, double unitPrice, Theatre theatre){
        this.title = title;
        this.unitPrice = unitPrice;
        this.theatre = theatre;
        tickets = new ArrayList<Ticket>();
        (theatre.getSeats()).forEach((seat) -> {
            Ticket ticket = new Ticket( title, seat.getLabel(), eventDate, eventTime);
            tickets.add(ticket);
        });
    }

    public ArrayList<Ticket> reserveTicket(int noOfTickets){
        ArrayList<Ticket> purchasedTickets = new ArrayList<Ticket>();
        if (tickets.size() > 0){

            if (tickets.size() < noOfTickets) {
                System.out.println(String.format("No ticket reserved. Only %d ticket left", tickets.size()));
                return null;
            } else {
                for (int i=0; i<noOfTickets; i++){
                    purchasedTickets.add(tickets.get(i));
                    tickets.remove(i);
                }
            }
        } else {
            System.out.println("Theatre is FULL!");
            return null;
        }
        return purchasedTickets;
    }
}
