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
import java.util.Map;
import java.util.TreeMap;

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

    public static void writeCsvFromArrayList(List<OutputRecord> outputRecords){

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

    public static void processLineByLineFromInput(String csvFlePath){
        try (BufferedReader br = new BufferedReader(new FileReader(csvFlePath))) {
            String line;

            Map<String, OutputRecord> outputRecords = new TreeMap<>();

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                Long timestamp = Long.parseLong(fields[0]);
                String symbol = fields[1];
                int quantity = Integer.parseInt(fields[2]);
                int price = Integer.parseInt(fields[3]);

                InputRecord currInput = new InputRecord(timestamp, symbol, quantity,price);
                if(outputRecords.get(currInput.getSymbol()) == null){
                    OutputRecord outputRecord = new OutputRecord();
                    outputRecord.setMaxTimeGap(0);
                    outputRecord.setTotalVolumeTraded(currInput.getQuantity());
                    outputRecord.setMaxTradePrice(currInput.getPrice());
                    outputRecord.setNumerator((currInput.getPrice()*currInput.getQuantity()));
                    outputRecord.setDenominator( currInput.getQuantity());
                    outputRecord.setSymbol(currInput.getSymbol());
                    outputRecord.setPrevTimestamp(currInput.getTimestamp());
                    outputRecords.put(currInput.getSymbol(),outputRecord);
                }else{
                    OutputRecord outputRecord = outputRecords.get(currInput.getSymbol());
                    outputRecord.setMaxTimeGap(Math.max(outputRecord.getMaxTimeGap(),(int)(currInput.getTimestamp()- outputRecord.getPrevTimestamp())));
                    outputRecord.setTotalVolumeTraded(outputRecord.getTotalVolumeTraded()+currInput.getQuantity());
                    outputRecord.setMaxTradePrice(Math.max(outputRecord.getMaxTradePrice(),currInput.getPrice()));
                    outputRecord.setNumerator(outputRecord.getNumerator() + (currInput.getPrice()*currInput.getQuantity()));
                    outputRecord.setDenominator(outputRecord.getDenominator() + currInput.getQuantity());
                    outputRecord.setSymbol(currInput.getSymbol());
                    outputRecord.setPrevTimestamp(currInput.getTimestamp());
                    outputRecords.put(currInput.getSymbol(),outputRecord);
                }

            }

            List<OutputRecord> outputRecordList = new ArrayList<>(outputRecords.values());

            writeCsvFromArrayList(outputRecordList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
