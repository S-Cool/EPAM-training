package com.kuliashou.shape.parser;

import com.kuliashou.shape.entity.Point;
import com.kuliashou.shape.entity.Triangle;

public class DataParser {

    private DataParser() {
    }

    public static Triangle pointParser(String line, String delimiter) {
        line = line.trim();
        String[] numberString = line.split(delimiter);
        Double[] numbers = new Double[6];
        for (int i = 0; i < 6; i++) {
            numbers[i] = Double.parseDouble(numberString[i]);
        }
        return new Triangle(new Point(numbers[0], numbers[1]),
                new Point(numbers[2], numbers[3]),
                new Point(numbers[4], numbers[5]));
    }

}
