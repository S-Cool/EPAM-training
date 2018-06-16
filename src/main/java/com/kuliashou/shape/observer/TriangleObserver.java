package com.kuliashou.shape.observer;

import com.kuliashou.shape.event.TriangleEvent;

public interface TriangleObserver {
    void handleEvent(TriangleEvent event);
}