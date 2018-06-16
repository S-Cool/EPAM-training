package com.kuliashou.shape.creator;

import com.kuliashou.shape.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

public class PointMaker implements FigureMaker {

    private static Logger logger = LogManager.getLogger();

    @Override
    public HashMap<Long, Figure> createFigures(ArrayList<Double[]> coordinates) {

        HashMap<Long, Figure> figures = new HashMap<>();

        for (Double[] coordinate : coordinates) {
            Point point = new Point(coordinate[0], coordinate[1]);
            figures.put(point.getPointId(), point);
        }
        logger.info("Points has created!");
        return figures;
    }
}
