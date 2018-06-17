package com.kuliashou.shape.creator;

import com.kuliashou.shape.entity.Point;
import com.kuliashou.shape.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<Figure> expected = new ArrayList<>();
        expected.add(triangleFirst);

        //When
        FigureMaker figure = new TriangleMaker();
        List<Figure> actual = figure.createFigures(data);

        //Then
        Assert.assertEquals(actual, expected);
    }
}