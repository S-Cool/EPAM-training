package com.kuliashou.shape.reader;

import com.kuliashou.shape.exception.TriangleException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Test
public class DataReaderTest {

    public void dataReaderTest() throws TriangleException {

        //Given
        List<String> expected = new ArrayList<>();
        expected.add("1.0, 2.0, 3.0, 1.0, 2.0, 3.0");
        expected.add("1.t, 2.9, 3.7, 1.t, 2.9, 3.7");
        expected.add("3.1, 4.5, 2.5, 5.0, 3.0, 2.0");
        expected.add("3.1, 4.5, 2.5");
        expected.add("3.1, 4.5");
        expected.add("3.5, 2.5, 1.5, 3.0, 2.0, 1.0");
        expected.add("-3.5, 2.5, -1.5, -3.0, 2.0, -1.0");

        //When
        List<String> actual = DataReader.readData("C:\\Users\\Ivan\\IdeaProjects\\shape\\data\\data.txt");

        //Then
        Assert.assertEquals(actual, expected);
    }


}