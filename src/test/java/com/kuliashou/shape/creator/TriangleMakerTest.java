package com.kuliashou.shape.creator;

import com.kuliashou.shape.entity.Point;
import com.kuliashou.shape.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class TriangleMakerTest {

    @Test
    public void testCreateFigure() {

        //Given
        Double[] first = {1.0, 2.0, 3.0, 1.0, 2.0, 3.0};
        ArrayList<Double[]> data = new ArrayList<>();
        data.add(first);

        Triangle triangleFirst = new Triangle(
                new Point(1.0, 2.0),
                new Point(3.0, 1.0),
                new Point(2.0, 3.0));
        HashMap<Integer, Figure> expected = new HashMap<>();
        expected.put(new Integer(0), triangleFirst);

        //When
        FigureMaker figure = new TriangleMaker();
        HashMap<Integer, Figure> actual = figure.createFigures(data);

        //Then
        Assert.assertEquals(actual, expected);
    }
}