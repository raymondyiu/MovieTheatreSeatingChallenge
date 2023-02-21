package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Theatre implements IVenue {
    private String name;
    private String street;
    private String city;
    private String postalCode;
    private Event event;
    private ArrayList<Seat> seats;


    public Theatre() {
        super();
    }
    public String getName(){
        return name;
    }
    public String getStreet(){
        return street;
    }
    public String getCity(){
        return city;
    }
    public String getPostalCode(){
        return postalCode;
    }
    public String getSeats() {
        String allSeats="";
        for (int i=0; i<seats.size(); i++ ) {
            allSeats += seats.get(i).getLabel();
        }
        return allSeats;
    }

    public void readJson(String filename) {
        JSONParser parser = new JSONParser();
        seats = new ArrayList<Seat>();

        try {
            Path path = Paths.get(
                    ClassLoader.getSystemResource(filename).toURI());
            // Read the JSON file using a FileReader
            FileReader reader = new FileReader(path.toString());

            // Parse the JSON data into a JsonObject
            Object object = new JSONParser().parse(reader);
            JSONObject jsonObject = (JSONObject) object;

            // read theatre information from json file
            name = (String) jsonObject.get("name");
            street = (String) jsonObject.get("street");
            city = (String) jsonObject.get("city");
            postalCode = (String) jsonObject.get("postalCode");

            // assign the rows and seats information
            JSONArray rows = (JSONArray) jsonObject.get("rows");

            for (int i = 0; i < rows.size(); i++) {
                JSONObject row = (JSONObject) rows.get(i);
                String rowLabel = (String)row.get("name");
                JSONArray seatList = (JSONArray) row.get("seats");
                for (int j = 0; j < seatList.size(); j++) {
                    JSONObject seatObj = (JSONObject) seatList.get(j);
                    //String seatNumber = (String) seatObj.get("name");
                    Seat seat = new Seat(rowLabel, (String)seatObj.get("name"));
                    seats.add(seat);
                }
            }

            // Close the FileReader
            reader.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public String reserveTicket(){
        return null;
    }
}
