package com.kuliashou.shape.repository;

import com.kuliashou.shape.entity.Point;
import com.kuliashou.shape.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TriangleRepositoryTest {
    private TriangleRepository triangleRepository;
    private Triangle triangle;
    private Triangle triangleNew;

    @BeforeClass
    private void setUp() {
        triangle = new Triangle(
                new Point(1.0, 2.0),
                new Point(10.0, 4.0),
                new Point(15.0, 27.0));

        triangleNew = new Triangle(
                new Point(3.0, 3.0),
                new Point(3.0, 7.0),
                new Point(13.0, 23.0));

        triangleRepository = TriangleRepository.getInstance();
    }

    @AfterClass
    void tearDown() {
        triangleRepository = null;
        triangle = null;
        triangleNew = null;
    }

    @AfterMethod
    void tearDownMethod() {
        triangleRepository.delete(triangle);
        triangleRepository.delete(triangleNew);
    }

    @Test
    public void testAddByIndex() {
        //When
        triangleRepository.addByIndex(0, triangle);
        Triangle actual = triangleRepository.readByIndex(0);

        //Then
        Assert.assertEquals(actual, triangle);
    }

    @Test
    public void testUpdate() {
        //Given
        triangleRepository.addByIndex(0, triangle);

        //When
        triangleRepository.update(triangle, triangleNew);
        Triangle actual = triangleRepository.readByIndex(0);

        //Then
        Assert.assertEquals(actual, triangleNew);
    }
}