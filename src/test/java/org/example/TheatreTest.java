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
    }

    @Test
    void reserveTicket() {
    }
}