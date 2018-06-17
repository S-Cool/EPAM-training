package com.kuliashou.shape.repository;

import com.kuliashou.shape.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {

    void add(T triangle);
    void addByIndex(int index, T triangle);
    T readByIndex(int id);
    void update(T oldTriangle, T newTriangle);
    void delete(T triangle);

    List<T> query(Specification specification);

    void sort(Comparator<T> comparator);

}
