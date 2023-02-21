package org.example;

import java.util.ArrayList;

public class Theatre implements IVenue {
    private String name;
    private String street;
    private String city;
    private String postalCode;
    private Event event;
    private ArrayList<String> seats;
    public String getName(){
        return name;
    }
    public void readJson(String filename) {

    }
    public String reserveTicket(){
        return(seats.get(0));
    }
}
