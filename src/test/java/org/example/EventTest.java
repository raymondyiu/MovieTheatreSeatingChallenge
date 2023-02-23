package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void reserveTicket() {
        Theatre theatre = new Theatre("Theatre.json");
        Event event = new Event("Event.json", theatre);
        assertEquals(15,event.getTicketAvailable());
        ArrayList<Ticket> purchasedTickets = event.reserveTicket(3);
        assertEquals(3, purchasedTickets.size());
        assertEquals(12,event.getTicketAvailable());
    }
}