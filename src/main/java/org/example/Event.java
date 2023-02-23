package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private final int FIRST_ELEMENT_INDEX = 0;
    private String title;
    private String Description;
    private LocalDate date;
    private LocalTime time;
    private double standardPrice;
    Theatre theatre;
    private List<Ticket> tickets;

    public Event(String filename, Theatre theatre) {
        readJson(filename);
        this.theatre = theatre;
        tickets = new ArrayList<Ticket>();
        for (Seat seat : theatre.getSeats()) {
            Ticket ticket = new Ticket(title, seat.getLabel(), date, time, standardPrice);
            tickets.add(ticket);
        }
    }

    private void readJson(String filename){
        JSONParser parser = new JSONParser();

        try {
            Path path = Paths.get(
                ClassLoader.getSystemResource(filename).toURI());
            // Read the JSON file using a FileReader
            FileReader reader = new FileReader(path.toString());

            // Parse the JSON data into a JsonObject
            Object object = new JSONParser().parse(reader);
            JSONObject jsonObject = (JSONObject) object;

            // read theatre information from json file
            title = (String) jsonObject.get("title");
            date = LocalDate.parse((String) jsonObject.get("date"), DateTimeFormatter.ofPattern("d-MMM-yyyy"));
            time = LocalTime.parse((String) jsonObject.get("time"));
            standardPrice = Double.parseDouble((String) jsonObject.get("price"));


            // Close the FileReader
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public int getTicketAvailable(){
        return tickets.size();
    }

    public String printAllLabel(){
        String output="";
        for (Ticket ticket : tickets){
            output += ticket.getSeatLabel();
        }
        return output;
    }

    public ArrayList<Ticket> reserveTicket(int noOfTickets){
        ArrayList<Ticket> purchasedTickets = new ArrayList<Ticket>();
        if (tickets.size() > 0){

            if (tickets.size() < noOfTickets) {
                System.out.println(String.format("No ticket reserved. Only %d ticket left", tickets.size()));
                return null;
            } else {
                for (int i=0; i<noOfTickets; i++){
                    purchasedTickets.add(tickets.get(FIRST_ELEMENT_INDEX));
                    tickets.remove(FIRST_ELEMENT_INDEX);
                }
            }
        } else {
            System.out.println("Theatre is FULL!");
            return null;
        }
        return purchasedTickets;
    }
}
