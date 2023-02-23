package org.example;

import java.util.ArrayList;

public abstract class Person {
    private String name;
    private String phoneNumber;
    private String emailAddress;


    public Person(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void printTicket(ArrayList<Ticket> tickets){
        if (tickets == null) {

            System.out.println(String.format("%s bought 0 ticket",name));
            return;
        }
        double totalPrice = 0;
        for (Ticket ticket : tickets){
            totalPrice += ticket.getPrice();
        }
        System.out.println(String.format("%s bought %d ticket%s for £%.2f", name, tickets.size(),
                ((tickets.size()==1) ? "" : "s"),
                totalPrice));
        int count=1;
        for (Ticket ticket : tickets){
            System.out.println(String.format("%s,Ticket#%d,%s,%s,%s", name,count,ticket.getSeatLabel(),ticket.getTitle(), ticket.getEventDate()));
            count += 1;
        }
    }
}
