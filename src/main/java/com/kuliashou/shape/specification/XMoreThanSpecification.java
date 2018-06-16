package com.kuliashou.shape.specification;

import com.kuliashou.shape.entity.Triangle;

public class XMoreThanSpecification implements Specification {
    private int minX;

    public XMoreThanSpecification(int minX) {
        this.minX = minX;
    }

    @Override
    public boolean specified(Triangle triangle) {
        return triangle.getPointA().getX() > minX ||
                triangle.getPointB().getX() > minX ||
                triangle.getPointC().getX() > minX;
    }
}
