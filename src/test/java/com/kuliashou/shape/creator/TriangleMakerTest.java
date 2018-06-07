package com.kuliashou.shape.creator;

import com.kuliashou.shape.entity.Point;
import com.kuliashou.shape.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TriangleMakerTest {

    @Test
    public void testCreateFigure() {

        //Given
        Double[] first = {1.0, 2.0, 3.0, 1.0, 2.0, 3.0};
        Double[] second = {3.1, 4.5, 2.5, 5.0, 3.0, 2.0};
        ArrayList<Double[]> data = new ArrayList<>();
        data.add(first);
        data.add(second);

        ArrayList<Figure> expected = new ArrayList<>();
        expected.add(new Triangle(new Point(1.0, 2.0),
                new Point(3.0, 1.0),
                new Point(2.0, 3.0)));
        expected.add(new Triangle(new Point(3.1, 4.5),
                new Point(2.5, 5.0),
                new Point(3.0, 2.0)));

        //When
        FigureMaker figure = new TriangleMaker();
        ArrayList<Figure> actual = figure.createFigure(data);

        //Then
        Assert.assertEquals(actual, expected);
    }
}