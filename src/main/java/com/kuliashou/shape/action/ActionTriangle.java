package com.kuliashou.shape.action;

import com.kuliashou.shape.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class ActionTriangle {

    private static final Logger logger = LogManager.getLogger();

    public double calculateArea(Triangle triangle) {

        double a = ActionTriangle.calculateSideA(triangle);
        double b = ActionTriangle.calculateSideB(triangle);
        double c = ActionTriangle.calculateSideC(triangle);
        double p = (a + b + c) / 2;
        double area = sqrt(p * (p - a) * (p - b) * (p - c));

        logger.info("Area has calculated!");

        return area;
    }

    public double calculatePerimeter(Triangle triangle) {

        double a = ActionTriangle.calculateSideA(triangle);
        double b = ActionTriangle.calculateSideB(triangle);
        double c = ActionTriangle.calculateSideC(triangle);
        double perimeter = a + b + c;

        logger.info("Perimeter has calculated!");

        return perimeter;
    }

    public boolean checkIsTriangle(Triangle triangle) {
        double left = (triangle.getPointA().getX() - triangle.getPointC().getX())
                / (triangle.getPointB().getX() - triangle.getPointC().getX());

        double right = (triangle.getPointA().getY() - triangle.getPointC().getY())
                / (triangle.getPointB().getY() - triangle.getPointC().getY());

        boolean conclusion = !(left == right) ? true : false;

        logger.info("The Figure is verified that it's triangle!");

        return conclusion;
    }

    public boolean checkIsRectangular(Triangle triangle) {
        double a = ActionTriangle.calculateSideA(triangle);
        double b = ActionTriangle.calculateSideB(triangle);
        double c = ActionTriangle.calculateSideC(triangle);
        boolean conclusion = sqrt(abs(a)) + sqrt(abs(c)) == sqrt(abs(b)) ||
                sqrt(abs(c)) + sqrt(abs(b)) == sqrt(abs(a)) ||
                sqrt(abs(a)) + sqrt(abs(b)) == sqrt(abs(c));

        logger.info("The Figure is verified that it's rectangular!");

        return conclusion;
    }

    private static double calculateSideA(Triangle triangle) {
        double dx = (triangle.getPointA().getX() - triangle.getPointB().getX());
        double dy = (triangle.getPointA().getY() - triangle.getPointB().getY());
        return Math.hypot(dx, dy);
    }

    private static double calculateSideB(Triangle triangle) {
        double dx = (triangle.getPointB().getX() - triangle.getPointC().getX());
        double dy = (triangle.getPointB().getY() - triangle.getPointC().getY());
        return Math.hypot(dx, dy);
    }

    private static double calculateSideC(Triangle triangle) {
        double dx = (triangle.getPointC().getX() - triangle.getPointA().getX());
        double dy = (triangle.getPointC().getY() - triangle.getPointA().getY());
        return Math.hypot(dx, dy);
    }
}
