package com.kuliashou.shape.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    private static Logger logger = LogManager.getLogger();

    private DataParser() {
    }

    public static ArrayList<Double[]> dataParser(List<String> data, String delimiter) {

        ArrayList<Double[]> parsedData = new ArrayList<>();

        for (String line : data) {
            line = line.trim();
            String[] numberString = line.split(delimiter);
            Double[] numbers = new Double[numberString.length];

            for (int index = 0; index < numbers.length; index++) {
                numbers[index] = Double.parseDouble(numberString[index]);
            }
            parsedData.add(numbers);
        }
        logger.info("Data has parsed!");
        return parsedData;
    }

}
