package com.kuliashou.shape.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateTest {

    @Test
    public void pointValidateTest() {

        //Given
        String line = "3.0, 5.0";
        String delimiter = ",";

        //When
        Boolean actual = Validate.validatePoint(line, delimiter);

        //Then
        Assert.assertTrue(actual);

    }

}