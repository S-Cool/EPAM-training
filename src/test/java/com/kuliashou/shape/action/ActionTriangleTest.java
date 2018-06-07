package com.kuliashou.shape.action;

import com.kuliashou.shape.entity.Point;
import com.kuliashou.shape.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionTriangleTest {

    @Test
    public void testCalculateArea() {

        //Given
        Triangle triangle = new Triangle(new Point(1.0, 1.0),
                new Point(3.0, 3.0),
                new Point(4.0, 0.0));

        double expected = 4.0;

        //When
        double actual = ActionTriangle.calculateArea(triangle);

        //Then
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void testCalculatePerimeter() {

        //Given
        Triangle triangle = new Triangle(new Point(1.0, 1.0),
                new Point(3.0, 3.0),
                new Point(4.0, 0.0));

        double expected = 9.1529;

        //When
        double actual = ActionTriangle.calculatePerimeter(triangle);

        //Then
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void testCheckIsTriangle() {

        //Given
        Triangle triangle = new Triangle(new Point(1.0, 1.0),
                new Point(3.0, 3.0),
                new Point(4.0, 0.0));

        //When
        boolean expected = ActionTriangle.checkIsTriangle(triangle);

        //Then
        Assert.assertTrue(expected);
    }

    @Test
    public void testCheckIsRectangular() {

        //Given
        Triangle triangle = new Triangle(new Point(1.0, 1.0),
                new Point(1.0, 3.0),
                new Point(3.0, 1.0));

        //When
        boolean expected = ActionTriangle.checkIsRectangular(triangle);

        //Then
        Assert.assertTrue(expected);
    }
}