package com.kuliashou.shape.parser;

import org.testng.Assert;
import org.testng.annotations.Test;


public class DataParserTest {

    @Test
    public void dataParserTest() {

        //Given
        String line = "3.0, 2.0, 4.0, 3.0, 2.0, 4.0";
        String delimiter = ",";
        Double[] excepted = {3.0, 2.0, 4.0, 3.0, 2.0, 4.0};

        //When
        Double[] actual = DataParser.pointParser(line, delimiter);

        //Then
        Assert.assertEquals(actual, excepted);

    }
}