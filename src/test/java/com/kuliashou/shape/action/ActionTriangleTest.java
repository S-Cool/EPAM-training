package com.kuliashou.shape.action;

import com.kuliashou.shape.entity.Point;
import com.kuliashou.shape.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionTriangleTest {

    @Test
    public void checkIsTriangleTest() {

        //Given
        Triangle triangle = new Triangle(new Point(1.0, 1.0),
                new Point(1.0, 1.0),
                new Point(1.0, 1.0));

        //When
        boolean expected = ActionTriangle.checkIsTriangle(triangle);

        //Then
        Assert.assertTrue(expected);
    }

}