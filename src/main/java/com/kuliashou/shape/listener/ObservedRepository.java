package com.kuliashou.shape.listener;

public interface ObservedRepository {
    void addObserver(ObserverRepository observer);
    void removeObserver(ObserverRepository observer);
    void notifyObservers();
}