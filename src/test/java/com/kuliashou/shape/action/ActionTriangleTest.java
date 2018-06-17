package com.kuliashou.shape.action;

import com.kuliashou.shape.entity.Point;
import com.kuliashou.shape.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionTriangleTest {

    private Triangle triangle;

    @BeforeClass
    private void setUp() {
        triangle = new Triangle(new Point(1.0, 1.0),
                new Point(3.0, 3.0),
                new Point(4.0, 0.0));
    }

    @AfterTest
    void tearDown() {
        triangle = null;
    }


    @Test
    public void testCalculateArea() {
        //Given
        double expected = 4.0;

        //When
        double actual = new ActionTriangle().calculateArea(triangle);

        //Then
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void testCalculatePerimeter() {
        //Given
        double expected = 9.1529;

        //When
        double actual = new ActionTriangle().calculatePerimeter(triangle);

        //Then
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void testCheckIsTriangle() {
        //When
        boolean expected = new ActionTriangle().checkIsTriangle(triangle);

        //Then
        Assert.assertTrue(expected);
    }

    @Test
    public void testCheckIsRectangular() {
        //When
        boolean expected = new ActionTriangle().checkIsRectangular(triangle);

        //Then
        Assert.assertFalse(expected);
    }
}