package com.kuliashou.shape.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class DataParser {

    private static Logger logger = LogManager.getLogger();

    private DataParser() {
    }

    public static ArrayList<Double[]> dataParser(ArrayList<String> data, String delimiter) {

        ArrayList<Double[]> parsedData = new ArrayList<>();

        for (String line : data) {
            line = line.trim();
            String[] numberString = line.split(delimiter);
            Double[] numbers = new Double[numberString.length];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Double.parseDouble(numberString[i]);
            }
            parsedData.add(numbers);
        }
        logger.info("Data has parsed!");
        return parsedData;
    }

}
