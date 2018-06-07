package com.kuliashou.shape.creator;

import com.kuliashou.shape.entity.Point;
import com.kuliashou.shape.entity.Triangle;

import java.util.ArrayList;

public class TriangleMaker implements FigureMaker {

    @Override
    public ArrayList<Figure> createFigure(ArrayList<Double[]> coordinates) {

        ArrayList<Figure> figures = new ArrayList<>();

        for (Double[] coordinate : coordinates) {
            Triangle triangle = new Triangle(new Point(coordinate[0], coordinate[1]),
                    new Point(coordinate[2], coordinate[3]),
                    new Point(coordinate[4], coordinate[5]));
            figures.add(triangle);
        }

        return figures;
    }

}
