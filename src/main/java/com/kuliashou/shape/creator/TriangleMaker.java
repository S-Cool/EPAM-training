package com.kuliashou.shape.creator;

import com.kuliashou.shape.entity.Point;
import com.kuliashou.shape.entity.Triangle;

public class TriangleMaker implements FigureMaker {

    @Override
    public Figure createFigure(Double[] point) {
        return new Triangle(new Point(point[0], point[1]),
                new Point(point[2], point[3]),
                new Point(point[4], point[5]));
    }

}
