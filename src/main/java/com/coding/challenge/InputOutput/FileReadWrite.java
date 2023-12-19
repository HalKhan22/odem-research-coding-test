package com.coding.challenge.InputOutput;

import com.coding.challenge.data.InputRecord;
import com.coding.challenge.data.OutputRecord;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReadWrite {

    public static List<InputRecord> readCsvAndCreateObjects(String csvFilePath) {
        List<InputRecord> inputRecordList = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            String[] row;

            while ((row = csvReader.readNext()) != null) {
                Long timestamp = Long.parseLong(row[0]);
                String symbol = row[1];
                int quantity = Integer.parseInt(row[2]);
                int price = Integer.parseInt(row[3]);

                InputRecord person = new InputRecord(timestamp, symbol, quantity,price);
                inputRecordList.add(person);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return inputRecordList;
    }

    public void writeCsvFromArrayList(List<OutputRecord> outputRecords){

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter("src/main/resources/output.csv"))) {
            // Write data
            for (OutputRecord outputRecord : outputRecords) {
                csvWriter.writeNext(new String[]{outputRecord.getSymbol(), String.valueOf(outputRecord.getMaxTimeGap()), String.valueOf(outputRecord.getTotalVolumeTraded()),  String.valueOf(outputRecord.getWeightedAvgPrice()),  String.valueOf(outputRecord.getMaxTradePrice()) });
            }

            System.out.println("Data has been written to output.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
