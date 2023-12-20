# odem-research-coding-test

## Table of Contents

- [Introduction](#introduction)
- [Requirements](#requirements)
- [Usage](#usage)
    - [Example Usage](#example-usage)
- [Approach and the amount of time spent](#Approach and the amount of time spent)


## Introduction

This java program reads a CSV file as stores into a list of type InputRecord. These records are grouped and processed in streams to generate the collection of type OutputRecord which is written to the csv file 'output.csv' in the
resources folder.



## Requirements

- Java 8 or higher


## Limitations 

This program is not capable of handling large csv files. 

One approach would be to use parallel processing on the methods of streams. It would still be confined to the number of cores of the server running this program.
Another approach is to use something similar map reduce of HDFS. 



### Example Usage
This program can be executed by running the main method of CodingChallenge java class. It expects the input file to be present in the resouces folder and takes the file name as input and writes to the output.csv file in the same directory. 

## Approach and the amount of time spent

I spent a good 4 hours on this whole assignment,

- I wrote the CalculateParameters class with all the basic aritmatic operations in a Test Driven Approach. 
- Then I leveraged this utils and started on GenerateOutput class by progressively writing each method in the similar TDD fashion. 
- First I tested this with the small sample set. 
- After the logic itself was working fine, I wrote a utility to read the CSV and write to CSV in FileReadWrite class and unit tested it.
- Finally, I wrote the CodingChallenge class with the main method having the scanner class and made it intractable. 