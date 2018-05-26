package com.kuliashou.shape.parser;

import com.kuliashou.shape.entity.Point;
import com.kuliashou.shape.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DataParserTest {

    @Test
    public void dataParserTest() {

        //Given
        String line = "3.0, 2.0, 4.0, 3.0, 2.0, 4.0";
        String delimiter = ",";
        Triangle excepted = new Triangle(new Point(3.0, 2.0),
                new Point(4.0, 3.0),
                new Point(2.0, 4.0));

        //When
        Triangle actual = DataParser.pointParser(line, delimiter);

        //Then
        Assert.assertEquals(actual, excepted);

    }
}