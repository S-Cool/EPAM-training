package com.kuliashou.shape.validator;

import com.kuliashou.shape.constant.PointConstant;
import com.kuliashou.shape.constant.TriangleConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Validate {

    private static Logger logger = LogManager.getLogger();

    public static List<String> validateData(List<String> list, String delimiter) {

        ArrayList<String> validateList = new ArrayList<>();

        for (String line : list) {
            if (validateLine(line, delimiter)) {
                validateList.add(line);
            }
        }
        logger.info("File with data has validated!");
        return validateList;
    }

    private static boolean validateLine(String line, String delimiter) {

        line = line.trim().replaceAll("\\s", "");
        String[] numbers = line.split(delimiter);
        Pattern coordinateRegExp = Pattern.compile(PointConstant.COORDINATE_REGEXP);

        for (int index = 0; index < TriangleConstant.COORDINATES_COUNT; index++) {
            if (numbers.length != TriangleConstant.COORDINATES_COUNT || !coordinateRegExp.matcher(numbers[index]).matches()) {
                return false;
            }
        }

        return true;
    }
}
