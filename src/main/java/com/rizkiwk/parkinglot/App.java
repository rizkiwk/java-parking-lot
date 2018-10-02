package com.rizkiwk.parkinglot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {

        switch (args.length) {
        case 0:
            System.out.println("Please enter 'exit' to quit");
            System.out.println("Waiting for input command ...");

            for (;;) {
                try {
                    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                    String inputString = bufferRead.readLine();
                    if (inputString.equalsIgnoreCase("exit")) {
                        break;
                    } else if ((inputString == null) || (inputString.isEmpty())) {

                    } else {
                        FileParser.parseTextInput(inputString.trim());
                    }
                } catch (IOException e) {
                    System.out.println("Oops! Error in reading the input from console.");
                    e.printStackTrace();
                }
            }
            break;
        case 1:
            FileParser.parseInputFile(args[0]);
            break;
        default:
            String filePath = "input.txt";
            FileParser.parseInputFile(filePath);
        }

    }

}
