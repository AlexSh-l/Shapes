package com.alex.shape.repository;

import com.alex.shape.comparator.*;
import com.alex.shape.entity.CustomFigure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomRepository {

    private static CustomRepository instance;
    private static final Comparator<CustomFigure> comparator = new IdComparator()
            .thenComparing(new NameComparator()
                    .thenComparing(new XComparator()
                            .thenComparing(new YComparator()
                                    .thenComparing(new ZComparator()
                                            .thenComparing(new PerimeterComparator()
                                                    .thenComparing(new SquareComparator()
                                                            .thenComparing(new VolumeComparator())))))));
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

    public void removeById(int id) {
        warehouse.removeIf(figure -> figure.getId() == id);
    }

    public boolean contains(CustomFigure figure) {
        return warehouse.contains(figure);
    }

    public void sort() {
        warehouse.sort(comparator);
    }

    public Object[] toArray(){
        return this.warehouse.toArray();
    }

    public void clear(){
        warehouse.clear();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomRepository{");
        sb.append("warehouse=").append(warehouse);
        sb.append('}');
        return sb.toString();
    }
}
