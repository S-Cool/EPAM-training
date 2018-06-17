package com.kuliashou.shape.creator;

import com.kuliashou.shape.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PointMaker implements FigureMaker {

    private static Logger logger = LogManager.getLogger();

    @Override
    public List<Figure> createFigures(ArrayList<Double[]> coordinates) {

        List<Figure> figures = new ArrayList<>();

        for (Double[] coordinate : coordinates) {
            Point point = new Point(coordinate[0], coordinate[1]);
            figures.add(point);
        }
        logger.info("Points has created!");
        return figures;
    }
}
