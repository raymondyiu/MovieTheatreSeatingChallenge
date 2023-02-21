package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheatreTest {

    @Test
    void getName() {
    }

    @Test
    void readJson() {
        Theatre theatre = new Theatre();
        theatre.readJson("Theatre.json");
        assertEquals("Ray Theatre", theatre.getName());
        assertEquals("5 Theatre Street", theatre.getStreet());
        assertEquals("Kingston", theatre.getCity());
        assertEquals("KT1 9XX", theatre.getPostalCode());
        assertEquals("A1 A2 A3 A4 A5 B1 B2 B3 B4 B5 C1 C2 C3 C4 C5", theatre.getSeats());
    }

    @Test
    void reserveTicket() {
    }
}