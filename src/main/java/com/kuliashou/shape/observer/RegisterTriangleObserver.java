package com.kuliashou.shape.observer;

import com.kuliashou.shape.entity.Triangle;
import com.kuliashou.shape.event.TriangleEvent;
import com.kuliashou.shape.registrar.TriangleRegister;

public class RegisterTriangleObserver implements TriangleObserver {

    @Override
    public void handleEvent(TriangleEvent event) {
        Triangle triangle = event.getSource();
        TriangleRegister.getInstance().recalculate(triangle);
    }
}
