package com.kuliashou.shape.repository;

import com.kuliashou.shape.entity.Triangle;
import com.kuliashou.shape.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TriangleRepository implements Repository<Triangle> {
    private static Logger logger = LogManager.getLogger();
    private static TriangleRepository instance;
    private List<Triangle> triangles = new ArrayList<>();

    public static TriangleRepository getInstance() {
        if (instance == null) {
            instance = new TriangleRepository();
        }
        logger.info("Triangle repository has created.");
        return instance;
    }

    private TriangleRepository() {
    }

    @Override
    public void add(Triangle triangle) {
        triangles.add(triangle);
    }

    @Override
    public void addByIndex(int index, Triangle triangle) {
        triangles.add(index, triangle);
    }

    @Override
    public Triangle readByIndex(int index) {
        return triangles.get(index);
    }

    @Override
    public void update(Triangle oldTriangle, Triangle newTriangle) {
        int indexOf = triangles.indexOf(oldTriangle);
        triangles.set(indexOf, newTriangle);
    }

    @Override
    public void delete(Triangle triangle) {
        triangles.remove(triangle);
    }

    @Override
    public List<Triangle> query(Specification specification) {
        List<Triangle> result = new ArrayList<>();
        for (Triangle triangle : triangles) {
            if (specification.specified(triangle)) {
                result.add(triangle);
            }
        }
        return result;
    }

    @Override
    public void sort(Comparator<Triangle> comparator) {
        triangles.sort(comparator);
    }
}
