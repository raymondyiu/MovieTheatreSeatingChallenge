package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class seatAllocationTest {

    public List<String[]> readCsv(String filename) {
        List<String[]> allData = new ArrayList<>();
        try {
            Path path = Paths.get(
                    ClassLoader.getSystemResource(filename).toURI());
            Reader reader = Files.newBufferedReader(path);
            CSVReader csvReader = new CSVReaderBuilder(reader).build();
            allData = csvReader.readAll();

        } catch (Exception e){
            e.printStackTrace();
        }
        return allData;
    }

    @Test
    void seatAllocation() {
        Random random = new Random();
        Theatre theatre = new Theatre("Theatre.json");
        Event event = new Event("Event.json", theatre);
        assertEquals(theatre.printSeats(), event.printAllLabel());
        assertEquals(15,event.getTicketAvailable());
        List<String[]> csvTestCases = new ArrayList<>();
        csvTestCases = readCsv("testcases.csv");
        for (String[] item : csvTestCases) {
            Customer customer = new Customer(item[0], item[1]);
            assertEquals(item[0], customer.getName());
            assertEquals(item[1], customer.getEmailAddress());
            int randomNumber = random.nextInt(3) + 1;
            ArrayList<Ticket> tickets = event.reserveTicket(randomNumber);
            customer.printTicket(tickets);
            if (tickets == null ) return;
        }
    }
}