package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private String title;
    private String seatLabel;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private double price;
    public Ticket(String title, String seatLabel, LocalDate date, LocalTime time, double price) {
        this.title = title;
        this.seatLabel = seatLabel;
        this.eventDate = date;
        this.eventTime = time;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getSeatLabel() {
        return seatLabel;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public double getPrice() {
        return price;
    }
}
