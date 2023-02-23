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
        System.out.println(String.format("%s bought %d ticket%s", name, tickets.size(),
                ((tickets.size()==1) ? "" : "s")
                ));
        int count=1;
        for (Ticket ticket : tickets){
            System.out.println(String.format("%s,Ticket#%d,%s,%s,%s", name,count,ticket.getSeatLabel(),ticket.getTitle(), ticket.getEventDate()));
            count += 1;
        }
    }
}
