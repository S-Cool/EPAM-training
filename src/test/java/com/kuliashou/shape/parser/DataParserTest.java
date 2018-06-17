package com.kuliashou.shape.parser;

import com.kuliashou.shape.constant.DataConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataParserTest {

    @Test
    public void testDataParser() {

        //Given
        List<String> data = new ArrayList<>();
        data.add("1.0, 2.0, 3.0, 1.0, 2.0, 3.0");
        data.add("3.1, 4.5, 2.5, 5.0, 3.0, 2.0");

        Double[] first = {1.0, 2.0, 3.0, 1.0, 2.0, 3.0};
        Double[] second = {3.1, 4.5, 2.5, 5.0, 3.0, 2.0};
        List<Double[]> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);

        //When
        List<Double[]> actual = DataParser.dataParser(data, DataConstant.DELIMITER);

        //Then
        for (int index = 0; index < data.size(); index++) {
            Assert.assertEquals(actual.get(index), expected.get(index));
        }

    }
}