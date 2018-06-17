package com.kuliashou.shape.event;

import com.kuliashou.shape.entity.Triangle;

import java.util.EventObject;

public class TriangleEvent extends EventObject {

    public TriangleEvent(Triangle source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }
}
