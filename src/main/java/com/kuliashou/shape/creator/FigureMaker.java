package com.kuliashou.shape.creator;

import java.util.ArrayList;
import java.util.List;

public interface FigureMaker {
    List<Figure> createFigures(ArrayList<Double[]> point);
}
