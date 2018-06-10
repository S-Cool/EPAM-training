package com.kuliashou.shape.registrar;

import com.kuliashou.shape.creator.Figure;
import com.kuliashou.shape.entity.Triangle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RegistrarMaker {

    public static HashMap<Integer, Registrar> createRegistrars(HashMap<Integer, Figure> data) {

        HashMap<Integer, Registrar> figuresWithCharacteristic = new HashMap<>();

        Iterator it = data.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Triangle triangle = (Triangle) pair.getValue();
            Registrar registrar = new Registrar(triangle);
            figuresWithCharacteristic.put(registrar.getREGISTRAR_ID(), registrar);
        }
        return figuresWithCharacteristic;
    }

    public static Registrar updateDataToRegistrar(Triangle triangle) {
        return new Registrar(triangle);
    }
}

