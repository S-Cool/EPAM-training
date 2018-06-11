package com.kuliashou.shape.listener;

import com.kuliashou.shape.registrar.Registrar;

import java.util.Map;

public interface ObserverRepository {
    void handleEvent(Map<Integer, Registrar> dataRegistrar);
}
