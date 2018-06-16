package com.kuliashou.shape.repository;

import com.kuliashou.shape.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {

    void add(T triangle);

    List<T> query(Specification specification);

    void sort(Comparator<T> comparator);

}
