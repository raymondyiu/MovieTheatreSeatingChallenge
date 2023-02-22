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
        Theatre theatre = new Theatre("Theatre.json");
        Event event = new Event("Lion King", "5-May-2023", "20:30:00", 14.0, theatre);
        assertEquals(15,event.getTicketAvailable());
        List<String[]> csvTestCases = new ArrayList<>();;
        csvTestCases = readCsv("testcases.csv");
        for (String[] item : csvTestCases) {
            Customer customer = new Customer(item[0], item[1]);
            assertEquals(item[0], customer.getName());
            assertEquals(Integer.valueOf(item[0]), bowling.score(item[1]));
        }
    }
}