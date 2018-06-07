package com.kuliashou.shape.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidateTest {

    @Test
    public void testValidateLineTrueData() {

        //Given
        String line = "-1.0, 2.0, 3.0, 1.0, 2.0, 3.0";
        String delimiter = ",";

        //When
        Boolean actual = Validate.validateLine(line, delimiter);

        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateLineFalseData() {

        //Given
        String line = "-1.t, 2.0, 3.0, 1.0, 2.0, 3.0";
        String delimiter = ",";

        //When
        Boolean actual = Validate.validateLine(line, delimiter);

        //Then
        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateData() {

        //Given
        List<String> list = new ArrayList<>();
        list.add("1.0, 2.0, 3.0, 1.0, 2.0, 3.0");
        list.add("1.t, 2.9, 3.7, 1.t, 2.9, 3.7");
        list.add("3.1, 4.5, 2.5, 5.0, 3.0, 2.0");
        list.add("3.1, 4.5, 2.5");
        list.add("3.1, 4.5");
        list.add("3.5, 2.5, 1.5, 3.0, 2.0, 1.0");
        list.add("-3.5, 2.5, -1.5, -3.0, 2.0, -1.0");

        String delimiter = ",";

        List<String> expected = new ArrayList<>();
        expected.add("1.0, 2.0, 3.0, 1.0, 2.0, 3.0");
        expected.add("3.1, 4.5, 2.5, 5.0, 3.0, 2.0");
        expected.add("3.5, 2.5, 1.5, 3.0, 2.0, 1.0");
        expected.add("-3.5, 2.5, -1.5, -3.0, 2.0, -1.0");

        //When
        ArrayList actual = Validate.validateData(list, delimiter);

        //Then
        Assert.assertEquals(actual, expected);
    }
}