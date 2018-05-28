package com.kuliashou.shape.creator;

import com.kuliashou.shape.entity.Point;
import com.kuliashou.shape.entity.Triangle;
import com.kuliashou.shape.exception.TriangleException;

public class Creator {

    public static Triangle triangleCreator(Double[] point) throws TriangleException {

        if (point == null) {
            throw new TriangleException("Can't create Triangle wrong points");
        }

        return new Triangle(new Point(point[0], point[1]),
                new Point(point[2], point[3]),
                new Point(point[4], point[5]));
    }

}
