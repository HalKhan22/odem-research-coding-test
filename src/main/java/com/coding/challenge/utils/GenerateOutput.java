package com.coding.challenge.utils;

import com.coding.challenge.InputOutput.FileReadWrite;
import com.coding.challenge.data.InputRecord;
import com.coding.challenge.data.OutputRecord;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Utility class for generating output records based on input records.
 */
public class GenerateOutput {

    private CalculateParameters calculateParameters;
    private FileReadWrite fileReadWrite;

    public GenerateOutput(CalculateParameters calculateParameters, FileReadWrite fileReadWrite) {
        this.calculateParameters = calculateParameters;
        this.fileReadWrite = fileReadWrite;
    }

    public GenerateOutput(CalculateParameters calculateParameters) {
    }
    /**
     * Creates an output record for each group of symbols.
     *
     * @param inputRecordsPerGroup List of input records for a specific symbol group
     * @return Output record for the group
     */
    public OutputRecord calculateEachOutputRecord(@NotNull ArrayList<InputRecord> inputRecordsPerGroup){
        OutputRecord outputRecord = new OutputRecord();

        // Extract prices and quantities from input records

        int[] prices = inputRecordsPerGroup.stream().map(e -> e.price).mapToInt(Integer::intValue).toArray();
        int[] quantities = inputRecordsPerGroup.stream().map(e -> e.quantity).mapToInt(Integer::intValue).toArray();

        // Set output record properties
        outputRecord.setMaxTimeGap(this.calculateParameters.calculateMaxTimeGap(inputRecordsPerGroup.stream().map(e -> e.timestamp).mapToLong(Long::longValue).toArray()));
        outputRecord.setSymbol(inputRecordsPerGroup.get(0).getSymbol());
        outputRecord.setMaxTradePrice(this.calculateParameters.calculateMaxValue(prices));
        outputRecord.setTotalVolumeTraded(this.calculateParameters.calculateSum(quantities));
        outputRecord.setWeightedAvgPrice(this.calculateParameters.calculateWeightedAveragePrice(quantities,prices));

        return outputRecord;
    }

    /**
     * Generates output records for each symbol group in the input records.
     *
     * @param inputRecords List of input records
     * @return List of output records
     */
    public ArrayList<OutputRecord> generateOutput(ArrayList<InputRecord> inputRecords){
        Map<String, ArrayList<InputRecord>> symbolMap = new TreeMap<>();
        ArrayList<OutputRecord> outputRecords = new ArrayList<>();

        // Group input records by symbol
        for(InputRecord inputRecord: inputRecords){
            if(symbolMap.containsKey(inputRecord.symbol)){
                ArrayList<InputRecord> newList = symbolMap.get(inputRecord.symbol);
                newList.add(inputRecord);
                symbolMap.put(inputRecord.symbol,newList);
            }else{
                symbolMap.put(inputRecord.symbol,new ArrayList<>(List.of(inputRecord)));
            }
        }

        // Calculate output records for each symbol group
        for(Map.Entry<String, ArrayList<InputRecord>> entry: symbolMap.entrySet()){
            outputRecords.add(calculateEachOutputRecord(entry.getValue()));
        }

        return outputRecords;

    }

    /**
     * Generates output records from a CSV file specified by the given path.
     *
     * @param path Path to the CSV file containing input records
     * @return List of output records
     */

    public ArrayList<OutputRecord> generateOutput(String path){

       ArrayList<InputRecord> inputRecords = (ArrayList<InputRecord>) this.fileReadWrite.readCsvAndCreateObjects(path);
       this.fileReadWrite.writeCsvFromArrayList(generateOutput(inputRecords));
       return generateOutput(inputRecords);


    }





}
