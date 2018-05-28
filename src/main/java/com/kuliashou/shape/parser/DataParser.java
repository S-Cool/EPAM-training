package com.kuliashou.shape.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataParser {

    private static Logger logger = LogManager.getLogger();

    private DataParser() {
    }

    public static Double[] pointParser(String line, String delimiter) {
        line = line.trim();
        String[] numberString = line.split(delimiter);
        Double[] numbers = new Double[6];
        for (int i = 0; i < 6; i++) {
            numbers[i] = Double.parseDouble(numberString[i]);
        }
        logger.info("Point has parsed");
        return numbers;
    }

}
