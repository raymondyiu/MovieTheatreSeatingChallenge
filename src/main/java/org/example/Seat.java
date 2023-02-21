package org.example;

public class Seat {
    private String row;
    private String seatNumber;
    private String label;
    public Seat(String row, String seatNumber) {
        this.row = row;
        this.seatNumber = seatNumber;
        this.label = row + seatNumber;
    }
    public String getRow() {
        return row;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public String getLabel() {
        return label;
    }
}
