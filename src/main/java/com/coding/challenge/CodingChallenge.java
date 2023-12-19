package com.coding.challenge;

import com.coding.challenge.InputOutput.FileReadWrite;
import com.coding.challenge.utils.CalculateParameters;
import com.coding.challenge.utils.GenerateOutput;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;

public class CodingChallenge {
    private static GenerateOutput generateOutputRecord = new GenerateOutput(new CalculateParameters(), new FileReadWrite());
  public static void main(String[] args) {
      // Create a Scanner to read from the command line
      Scanner scanner = new Scanner(System.in);

      System.out.println("Enter command-line arguments (separated by spaces):");

      // Read the entire line of input
      String inputLine = scanner.nextLine();

      // Split the input line into an array of strings
      String[] arguments = inputLine.split("\\s+");

      // Check if there are any arguments
      if (arguments.length > 0) {
          URL res = CodingChallenge.class.getClassLoader().getResource(arguments[0]);
          File file = null;
          try {
              file = Paths.get(res.toURI()).toFile();
          } catch (URISyntaxException e) {
              System.out.println("No such file");
          }

          String absolutePath = file.getAbsolutePath();
          generateOutputRecord.generateOutput(absolutePath);

      } else {
          System.out.println("No command-line arguments provided.");
      }

      // Close the scanner
      scanner.close();
  }
}
