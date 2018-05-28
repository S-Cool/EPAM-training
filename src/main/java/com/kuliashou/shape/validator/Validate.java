package com.kuliashou.shape.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class Validate {

    private static Logger logger = LogManager.getLogger();

    private static final Pattern COORDINATE_REGEXP = Pattern.compile("-?\\d+\\.\\d+");

    public static boolean validateLine(String line, String delimiter) {
        line = line.trim();
        String[] numbers = line.split(delimiter);

        if (numbers.length != 6) {
            return false;
        }
        for (int i = 0; i < 6; i++) {
            if (!validateCoordinate(numbers[i])) {
                return false;
            }
        }
        logger.info("Line has validated");
        return true;
    }

    private static boolean validateCoordinate(String num) {
        return COORDINATE_REGEXP.matcher(num).matches();
    }
}
