package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
        JSONParser parser = new JSONParser();
        try {
            Path path = Paths.get(
                    ClassLoader.getSystemResource(filename).toURI());
            FileReader reader = new FileReader(path);

            Gson gson = new Gson();
            JsonObject data = gson.fromJson(reader, JsonObject.class);

            name = JsonObject.get("name").getAsString();



        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public String reserveTicket(){
        return(seats.get(0));
    }
}
