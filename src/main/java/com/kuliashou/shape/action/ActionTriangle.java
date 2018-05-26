package com.kuliashou.shape.action;

import com.kuliashou.shape.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionTriangle {

    private static final Logger logger = LogManager.getLogger();

    public float calculateArea(Triangle triangle) {
        return 1;
    }

    public float calculatePerimeter(Triangle triangle) {
        return 1;
    }

    public boolean checkIsTriangle(Triangle triangle) {
        return false;
    }

    public boolean checkIsRectengular(Triangle triangle) {
        return false;
    }
}
