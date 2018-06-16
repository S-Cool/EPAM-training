package com.kuliashou.shape.specification;

import com.kuliashou.shape.action.ActionTriangle;
import com.kuliashou.shape.entity.Triangle;

public class IsRightTriangleSpecification implements Specification {
    @Override
    public boolean specified(Triangle triangle) {
        return new ActionTriangle().checkIsTriangle(triangle);
    }
}
