package com.kuliashou.shape.listener;

import com.kuliashou.shape.registrar.Registrar;

import java.util.HashMap;

public interface ObserverRepository {
    void handleEvent(HashMap<Integer, Registrar> dataRegistrar);
}
