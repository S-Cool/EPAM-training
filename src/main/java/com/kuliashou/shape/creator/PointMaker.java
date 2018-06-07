package com.kuliashou.shape.creator;

import com.kuliashou.shape.entity.Point;

import java.util.ArrayList;

public class PointMaker implements FigureMaker {

    @Override
    public ArrayList<Figure> createFigure(ArrayList<Double[]> coordinates) {

        ArrayList<Figure> figures = new ArrayList<>();

        for (Double[] coordinate : coordinates) {
            Point point = new Point(coordinate[0], coordinate[1]);
            figures.add(point);
        }

        return figures;
    }
}
