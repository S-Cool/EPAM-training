package com.kuliashou.shape.creator;

import com.kuliashou.shape.entity.Point;
import com.kuliashou.shape.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

public class TriangleMaker implements FigureMaker {

    private static Logger logger = LogManager.getLogger();

    @Override
    public HashMap<Integer, Figure> createFigures(ArrayList<Double[]> coordinates) {

        HashMap<Integer, Figure> figures = new HashMap<>();

        for (Double[] coordinate : coordinates) {
            Triangle triangle = new Triangle(new Point(coordinate[0], coordinate[1]),
                    new Point(coordinate[2], coordinate[3]),
                    new Point(coordinate[4], coordinate[5]));
            figures.put(triangle.getTriangleId(), triangle);
        }
        logger.info("Figures has created!");
        return figures;
    }

}
