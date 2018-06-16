package com.kuliashou.shape.observer;

public interface TriangleObserved {
    void addObserver(TriangleObserver observer);
    void removeObserver(TriangleObserver observer);
    void notifyObservers();
}