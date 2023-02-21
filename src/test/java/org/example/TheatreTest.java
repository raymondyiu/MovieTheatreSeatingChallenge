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
    }

    @Test
    void reserveTicket() {
    }
}