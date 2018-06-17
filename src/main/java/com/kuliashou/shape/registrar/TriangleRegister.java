package com.kuliashou.shape.registrar;

import com.kuliashou.shape.action.ActionTriangle;
import com.kuliashou.shape.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TriangleRegister {

    private static Logger logger = LogManager.getLogger();
    private static TriangleRegister instance;

    private Map<Long, Parameters> triangleParameters = new HashMap<>();

    private TriangleRegister() {
    }

    public static TriangleRegister getInstance() {
        if (instance == null) {
            instance = new TriangleRegister();
        }
        return instance;
    }

    private class Parameters {
        private double area;
        private double perimeter;

        private Parameters(double area, double perimeter) {
            this.area = area;
            this.perimeter = perimeter;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Parameters that = (Parameters) o;
            return Double.compare(that.area, area) == 0 &&
                    Double.compare(that.perimeter, perimeter) == 0;
        }

        @Override
        public int hashCode() {

            return Objects.hash(area, perimeter);
        }

        @Override
        public String toString() {
            return "Parameters{" +
                    "area=" + area +
                    ", perimeter=" + perimeter +
                    '}';
        }
    }

    public double findTriangleAreaById(Long triangleId) {
        if (!triangleParameters.containsKey(triangleId)) {
            return -1;
        }

        Parameters parameters = triangleParameters.get(triangleId);
        return parameters.area;
    }

    public double findTrianglePerimeterById(Long triangleId) {
        if (!triangleParameters.containsKey(triangleId)) {
            return -1;
        }

        Parameters parameters = triangleParameters.get(triangleId);
        return parameters.perimeter;
    }

    private Parameters calculateParameters(Triangle triangle) {
        ActionTriangle actionTriangle = new ActionTriangle();
        double perimeter = actionTriangle.calculatePerimeter(triangle);
        double area = actionTriangle.calculateArea(triangle);
        logger.info("Parameters for triangle " + triangle + " have calculated.");
        return new Parameters(area, perimeter);
    }

    public void recalculate(Triangle triangle) {
        if (triangleParameters.containsKey(triangle.getTriangleId())) {
            putTriangle(triangle);

            Parameters parameters = calculateParameters(triangle);
            triangleParameters.put(triangle.getTriangleId(), parameters);
            logger.info("The triangle "
                    + triangle + " received new perimeter "
                    + parameters.perimeter + " and area "
                    + parameters.area + ".");
        }
    }

    private void putTriangle(Triangle triangle) {
        triangleParameters.put(triangle.getTriangleId(), calculateParameters(triangle));
    }
}
