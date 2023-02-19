package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildingsTest {

    @Test
    void readTheatreJson() {
        Theatre theatre = new Theatre();
        theatre.readTheatreJson("theatre.json");
        assertEquals("ODEON", theatre.getName());
    }

    @Test
    void popTicket() {
    }
}