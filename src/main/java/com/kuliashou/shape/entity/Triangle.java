package com.kuliashou.shape.entity;

import com.kuliashou.shape.creator.Figure;

import java.util.Objects;

public class Triangle implements Figure {
    private static int counter = 0;
    private final int TRIANGLE_ID;
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.TRIANGLE_ID = counter++;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public int getTriangleId() {
        return TRIANGLE_ID;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return TRIANGLE_ID == triangle.TRIANGLE_ID &&
                Objects.equals(pointA, triangle.pointA) &&
                Objects.equals(pointB, triangle.pointB) &&
                Objects.equals(pointC, triangle.pointC);
    }

    @Override
    public int hashCode() {

        return Objects.hash(TRIANGLE_ID, pointA, pointB, pointC);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "TRIANGLE_ID=" + TRIANGLE_ID +
                ", pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                '}';
    }

    @Override
    public void showFigure() {
        toString();
    }
}
