package com.kuliashou.shape.creator;

import java.util.ArrayList;
import java.util.HashMap;

public interface FigureMaker {
    HashMap<Long, Figure> createFigures(ArrayList<Double[]> point);
}
