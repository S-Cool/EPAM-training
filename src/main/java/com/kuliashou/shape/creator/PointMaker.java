package com.kuliashou.shape.creator;

import com.kuliashou.shape.entity.Point;

public class PointMaker implements FigureMaker {

    @Override
    public Figure createFigure(Double[] point) {
        return new Point(point[0], point[1]);
    }
}
