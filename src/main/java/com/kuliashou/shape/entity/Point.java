package com.kuliashou.shape.entity;

import com.kuliashou.shape.creator.Figure;

import java.util.Objects;

public class Point implements Figure {
    private static int counter = 0;
    private final int POINT_ID;

    private double x;
    private double y;

    public Point(double x, double y) {
        this.POINT_ID = counter++;
        this.x = x;
        this.y = y;
    }

    public int getPOINT_ID() {
        return POINT_ID;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public void showFigure() {
        toString();
    }
}
