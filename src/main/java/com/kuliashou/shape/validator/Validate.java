package com.kuliashou.shape.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Validate {

    private static Logger logger = LogManager.getLogger();
    private static final Pattern COORDINATE_REGEXP = Pattern.compile("^-?\\d+\\.\\d+");

    public static ArrayList<String> validateData(List<String> list, String delimiter) {

        ArrayList<String> validateList = new ArrayList<>();

        for (String line : list) {
            if (validateLine(line, delimiter)) {
                validateList.add(line);
            }
        }
        logger.info("File with data has validated.");
        return validateList;
    }

    public static boolean validateLine(String line, String delimiter) {

        line = line.trim().replaceAll("\\s", "");
        String[] numbers = line.split(delimiter);

        if (numbers.length != 6) {
            return false;
        }
        for (int i = 0; i < 6; i++) {
            if (!COORDINATE_REGEXP.matcher(numbers[i]).matches()) {
                return false;
            }
        }

        return true;
    }
}
