package com.kuliashou.shape.creator;

import java.util.ArrayList;

public interface FigureMaker {
    ArrayList<Figure> createFigure(ArrayList<Double[]> point);
}
