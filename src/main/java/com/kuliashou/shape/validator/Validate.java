package com.kuliashou.shape.validator;

import java.util.regex.Pattern;

public class Validate {

    private static final Pattern COORDINATE_REGEXP = Pattern.compile("\\d+\\.\\d+");

    public static boolean validatePoint(String line, String delimiter) {
        line = line.trim();
        String[] numbers = line.split(delimiter);
        if (numbers.length != 2) {
            return false;
        }
        for (int i = 0; i < 2; i++) {
            if (!validateCoordinate(numbers[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateCoordinate(String num) {
        return COORDINATE_REGEXP.matcher(num).matches();
    }
}
