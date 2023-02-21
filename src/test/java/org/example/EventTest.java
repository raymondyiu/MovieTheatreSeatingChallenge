package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void reserveTicket() {
        Theatre theatre = new Theatre("Theatre.json");
        Event event = new Event("Lion King", "5-May-2023", "20:30:00", 14.0, theatre);
        ArrayList<Ticket> purchasedTickets = event.reserveTicket(3);
        assertEquals(1, purchasedTickets.size());
    }
}