package com.alex.shape.repository;

import com.alex.shape.entity.CustomFigure;

import java.util.ArrayList;
import java.util.List;

public class CustomRepository {

    private static CustomRepository instance;
    private final List<CustomFigure> warehouse = new ArrayList<>();

    private CustomRepository() {
    }

    public static CustomRepository getInstance() {
        if (instance == null) {
            instance = new CustomRepository();
        }
        return instance;
    }

    public void add(CustomFigure figure) {
        warehouse.add(figure);
    }

    public void remove(CustomFigure figure) {
        warehouse.remove(figure);
    }

    public void removeByIndex(int index) {
        warehouse.remove(index);
    }

    public void removeById(int id) {
        warehouse.removeIf(figure -> figure.getId() == id);
    }

    public boolean contains(CustomFigure figure) {
        return warehouse.contains(figure);
    }
}
