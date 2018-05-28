package com.kuliashou.shape.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateTest {

    @Test
    public void validateLineTest() {

        //Given
        String line = "1.0, 2.0, 3.0, 1.0, 2.0, 3.0";
        String delimiter = ",";

        //When
        Boolean actual = Validate.validateLine(line, delimiter);

        //Then
        Assert.assertTrue(actual);

    }

}