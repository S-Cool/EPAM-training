package com.kuliashou.shape.specification;

import com.kuliashou.shape.action.ActionTriangle;
import com.kuliashou.shape.entity.Triangle;

public class AreaBetweenSpecification implements Specification {

    private double minArea;
    private double maxArea;

    public AreaBetweenSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(Triangle triangle) {
        ActionTriangle actionTriangle = new ActionTriangle();
        double area = actionTriangle.calculateArea(triangle);
        return area > minArea && area < maxArea;
    }
}
