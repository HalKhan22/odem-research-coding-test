package com.coding.challenge.utils;

import com.coding.challenge.InputOutput.FileReadWrite;
import com.coding.challenge.data.InputRecord;
import com.coding.challenge.data.OutputRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

class GenerateOutputTest {

    private GenerateOutput generateOutputRecord = new GenerateOutput(new CalculateParameters(), new FileReadWrite());



    @Test
    void generateOutputRecord() {
        ArrayList<InputRecord> testInputRecords = new ArrayList<>();
        InputRecord record1 = new InputRecord(57124702L,"aaa",13,1136);
        InputRecord record2 = new InputRecord(57130489L,"aaa",18,1222);
        InputRecord record3 = new InputRecord(57131654L,"aaa",9,1077);
        testInputRecords.addAll(Arrays.asList(record1,record2,record3));

        OutputRecord expectedOutputRecord = new OutputRecord("aaa",5787,40,1222,1161);

        Assertions.assertEquals(expectedOutputRecord,generateOutputRecord.calculateEachOutputRecord(testInputRecords));
    }

      @Test
      void generateOutput() {
          ArrayList<InputRecord> testInputRecords = new ArrayList<>();
          InputRecord record1 = new InputRecord(57124702L,"aaa",13,1136);
          InputRecord record2 = new InputRecord(57130489L,"aaa",18,1222);
          InputRecord record3 = new InputRecord(57131654L,"aaa",9,1077);
          InputRecord record4 = new InputRecord(57125641L,"aab",31,907);
          InputRecord record5 = new InputRecord(57133453L,"aab",9,756);
          InputRecord record6 = new InputRecord(57127350L,"aab",29,724);
          InputRecord record7 = new InputRecord(57127783L,"aac",21,638);
          InputRecord record8 = new InputRecord(57124702L,"aac",20,477);

          testInputRecords.addAll(Arrays.asList(record1,record2,record3,record7,record8,record4,record5,record6));

          OutputRecord outputRecord1 = new OutputRecord("aaa",5787,40,1222,1161);
          OutputRecord outputRecord2 = new OutputRecord("aab",6103,69,907,810);
          OutputRecord outputRecord3 = new OutputRecord("aac",3081,41,638,559);

          ArrayList<OutputRecord> expectedOutputRecords = new ArrayList<>();
             expectedOutputRecords.addAll(Arrays.asList(outputRecord1,outputRecord2,outputRecord3));

    System.out.println(generateOutputRecord.generateOutput(testInputRecords));
         Assertions.assertEquals(expectedOutputRecords.size(),generateOutputRecord.generateOutput(testInputRecords).size());

      }

  @Test
  void testGenerateOutput() throws URISyntaxException {


      OutputRecord outputRecord1 = new OutputRecord("aaa",5787,40,1222,1161);
      OutputRecord outputRecord2 = new OutputRecord("aab",6103,69,907,810);
      OutputRecord outputRecord3 = new OutputRecord("aac",3081,41,638,559);

      ArrayList<OutputRecord> expectedOutputRecords = new ArrayList<>();
      expectedOutputRecords.addAll(Arrays.asList(outputRecord1,outputRecord2,outputRecord3));

      URL res = getClass().getClassLoader().getResource("input_data.csv");
      File file = Paths.get(res.toURI()).toFile();
      String absolutePath = file.getAbsolutePath();
     // Assertions.assertEquals(expectedOutputRecords.size(),generateOutputRecord.generateOutput(absolutePath).size());
  }
}