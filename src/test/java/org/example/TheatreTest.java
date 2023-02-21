package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheatreTest {

    @Test
    void readJson() {
        Theatre theatre = new Theatre("Theatre.json");
        assertEquals("Ray Theatre", theatre.getName());
        assertEquals("5 Theatre Street", theatre.getStreet());
        assertEquals("Kingston", theatre.getCity());
        assertEquals("KT1 9XX", theatre.getPostalCode());
        assertEquals("A1A2A3A4A5B1B2B3B4B5C1C2C3C4C5", theatre.getSeats());
    }

}