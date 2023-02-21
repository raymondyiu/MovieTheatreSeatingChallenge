package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    String title;
    String seatLabel;
    LocalDate eventDate;
    LocalTime eventTime;
    public Ticket(String title, String seatLabel, String eventDateStr, String eventTimeStr) {
        this.title = title;
        this.seatLabel = seatLabel;
        this.eventDate = LocalDate.parse(eventDateStr, DateTimeFormatter.ofPattern("d-MMM-yyyy"));
        this.eventTime = LocalTime.parse(eventTimeStr);
    }
}
