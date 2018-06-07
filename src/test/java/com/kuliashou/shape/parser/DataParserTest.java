package com.kuliashou.shape.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class DataParserTest {

    @Test
    public void testDataParser() {

        //Given
        String delimiter = ",";

        ArrayList<String> data = new ArrayList<>();
        data.add("1.0, 2.0, 3.0, 1.0, 2.0, 3.0");
        data.add("3.1, 4.5, 2.5, 5.0, 3.0, 2.0");

        Double[] first = {1.0, 2.0, 3.0, 1.0, 2.0, 3.0};
        Double[] second = {3.1, 4.5, 2.5, 5.0, 3.0, 2.0};
        ArrayList<Double[]> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);

        //When
        ArrayList<Double[]> actual = DataParser.dataParser(data, delimiter);

        //Then
        Assert.assertEquals(actual, expected);
    }
}