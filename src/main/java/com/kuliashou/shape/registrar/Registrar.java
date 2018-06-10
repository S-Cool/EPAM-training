package com.kuliashou.shape.registrar;

import com.kuliashou.shape.action.ActionTriangle;
import com.kuliashou.shape.entity.Triangle;

import java.util.Objects;

public class Registrar {

    private final int REGISTRAR_ID;

    private double area;
    private double perimeter;
    private boolean isTriangle;
    private boolean isRectangular;
    private Triangle triangle;

    public Registrar(Triangle triangle) {
        this.REGISTRAR_ID = triangle.getTriangleId();
        this.area = ActionTriangle.calculateArea(triangle);
        this.perimeter = ActionTriangle.calculatePerimeter(triangle);
        this.isTriangle = ActionTriangle.checkIsTriangle(triangle);
        this.isRectangular = ActionTriangle.checkIsRectangular(triangle);
        this.triangle = triangle;
    }

    public int getREGISTRAR_ID() {
        return REGISTRAR_ID;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public boolean isTriangle() {
        return isTriangle;
    }

    public void setTriangle(boolean triangle) {
        isTriangle = triangle;
    }

    public boolean isRectangular() {
        return isRectangular;
    }

    public void setRectangular(boolean rectangular) {
        isRectangular = rectangular;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registrar that = (Registrar) o;
        return Double.compare(that.area, area) == 0 &&
                Double.compare(that.perimeter, perimeter) == 0 &&
                isTriangle == that.isTriangle &&
                isRectangular == that.isRectangular &&
                Objects.equals(triangle, that.triangle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(area, perimeter, isTriangle, isRectangular, triangle);
    }

    @Override
    public String toString() {
        return "Registrar{" +
                "REGISTRAR_ID=" + REGISTRAR_ID +
                ", area=" + area +
                ", perimeter=" + perimeter +
                ", isTriangle=" + isTriangle +
                ", isRectangular=" + isRectangular +
                ", triangle=" + triangle +
                '}';
    }
}
