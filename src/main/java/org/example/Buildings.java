package org.example;

import java.util.ArrayList;

public abstract class Buildings {
    private String name;
    private String street;
    private String city;
    private String postalCode;
    private Event event;
    private ArrayList<String> seats;
    public String getName(){
        return name;
    }
    public void readTheatreJson(String filename){

    }
    public String popTicket(){
        return(seats.get(0));
    }
}
