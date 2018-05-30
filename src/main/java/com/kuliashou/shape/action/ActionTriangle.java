package com.kuliashou.shape.action;

import com.kuliashou.shape.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class ActionTriangle {

    private static final Logger logger = LogManager.getLogger();

    public static double calculateArea(Triangle triangle) {

        double a = ActionTriangle.calculateSideA(triangle);
        double b = ActionTriangle.calculateSideB(triangle);
        double c = ActionTriangle.calculateSideC(triangle);
        double p = ActionTriangle.calculatePerimeter(triangle) / 2;
        return sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static double calculatePerimeter(Triangle triangle) {

        double a = ActionTriangle.calculateSideA(triangle);
        double b = ActionTriangle.calculateSideB(triangle);
        double c = ActionTriangle.calculateSideC(triangle);

        return a + b + c;
    }

    public static boolean checkIsTriangle(Triangle triangle) {
        double left = (triangle.getPointA().getX() - triangle.getPointC().getX()) /
                (triangle.getPointB().getX() - triangle.getPointC().getX());

        double right = (triangle.getPointA().getY() - triangle.getPointC().getY()) /
                (triangle.getPointB().getY() - triangle.getPointC().getY());

        return !(left == right) ? true : false;
    }

    public static boolean checkIsRectengular(Triangle triangle) {
        double a = ActionTriangle.calculateSideA(triangle);
        double b = ActionTriangle.calculateSideB(triangle);
        double c = ActionTriangle.calculateSideC(triangle);
        return sqrt(abs(a)) + sqrt(abs(c)) == sqrt(abs(b)) |
                sqrt(abs(c)) + sqrt(abs(b)) == sqrt(abs(a)) |
                sqrt(abs(a)) + sqrt(abs(b)) == sqrt(abs(c));
    }

    public static double calculateSideA(Triangle triangle) {
        double dx = (triangle.getPointA().getX() - triangle.getPointB().getX());
        double dy = (triangle.getPointA().getY() - triangle.getPointB().getY());
        double a = Math.hypot(dx, dy);
        return a;
    }

    public static double calculateSideB(Triangle triangle) {
        double dx = (triangle.getPointB().getX() - triangle.getPointC().getX());
        double dy = (triangle.getPointB().getY() - triangle.getPointC().getY());
        double b = Math.hypot(dx, dy);
        return b;
    }

    public static double calculateSideC(Triangle triangle) {
        double dx = (triangle.getPointC().getX() - triangle.getPointA().getX());
        double dy = (triangle.getPointC().getY() - triangle.getPointA().getY());
        double c = Math.hypot(dx, dy);
        return c;
    }
}
