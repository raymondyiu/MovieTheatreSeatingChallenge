package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private final int FIRST_ELEMENT_INDEX = 0;
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
        for (Seat seat : theatre.getSeats()){
            Ticket ticket = new Ticket( title, seat.getLabel(), eventDate, eventTime);
            tickets.add(ticket);
        }
    }

    public int getTicketAvailable(){
        return tickets.size();
    }

    public String printAllLabel(){
        String output="";
        for (Ticket ticket : tickets){
            output += ticket.getSeatLabel();
        }
        return output;
    }

    public ArrayList<Ticket> reserveTicket(int noOfTickets){
        ArrayList<Ticket> purchasedTickets = new ArrayList<Ticket>();
        if (tickets.size() > 0){

            if (tickets.size() < noOfTickets) {
                System.out.println(String.format("No ticket reserved. Only %d ticket left", tickets.size()));
                return null;
            } else {
                for (int i=0; i<noOfTickets; i++){
                    purchasedTickets.add(tickets.get(FIRST_ELEMENT_INDEX));
                    tickets.remove(FIRST_ELEMENT_INDEX);
                }
            }
        } else {
            System.out.println("Theatre is FULL!");
            return null;
        }
        return purchasedTickets;
    }
}
