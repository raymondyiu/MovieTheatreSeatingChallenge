package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        try {
            Path path = Paths.get(
                    ClassLoader.getSystemResource(filename).toURI());
            Reader reader = Files.newBufferedReader(path);
            CSVReader csvReader = new CSVReaderBuilder(reader).build();
            allData = csvReader.readAll();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public String reserveTicket(){
        return(seats.get(0));
    }
}
