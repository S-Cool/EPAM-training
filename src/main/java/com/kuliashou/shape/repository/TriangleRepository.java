package com.kuliashou.shape.repository;

import com.kuliashou.shape.entity.Triangle;
import com.kuliashou.shape.exception.SingletonException;
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
            try {
                instance = new TriangleRepository();
            } catch (SingletonException e) {
                logger.catching(e);
            }
        }
        return instance;
    }

    private TriangleRepository() throws SingletonException {
        if (instance != null) {
            throw new SingletonException("Tried to create singleton with reflection API");
        }
    }

    @Override
    public void add(Triangle triangle) {
        triangles.add(triangle);
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
