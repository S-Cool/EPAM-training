package com.kuliashou.shape.registrar;

import com.kuliashou.shape.entity.Point;
import com.kuliashou.shape.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TriangleRegisterTest {
    private TriangleRegister triangleRegister;
    private Triangle triangle;

    @BeforeClass
    private void setUp() {
        triangle = new Triangle(
                new Point(1.0, 2.0),
                new Point(3.0, 4.0),
                new Point(7.0, 7.0));

        triangleRegister = TriangleRegister.getInstance();
        triangleRegister.putTriangle(triangle);

    }

    @AfterTest
    void tearDown() {
        triangleRegister = null;
        triangle = null;
    }

    @Test
    public void testFindTriangleAreaById() {
        //Given
        Double expected = 1.0000000000000042;

        //When
        double actual = triangleRegister.findTriangleAreaById(triangle.getTriangleId());

        //Then
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindTrianglePerimeterById() {
        //Given
        Double expected = 15.638676800652844;

        //When
        double actual = triangleRegister.findTrianglePerimeterById(triangle.getTriangleId());

        //Then
        Assert.assertEquals(actual, expected);
    }
}