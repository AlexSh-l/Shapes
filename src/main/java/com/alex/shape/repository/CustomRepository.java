package com.alex.shape.repository;

import com.alex.shape.comparator.*;
import com.alex.shape.entity.CustomFigure;
import com.alex.shape.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomRepository {

    private static CustomRepository instance;
    private static final Comparator<CustomFigure> comparator = new IdComparator()
            .thenComparing(new NameComparator()
                    .thenComparing(new XComparator()
                            .thenComparing(new YComparator()
                                    .thenComparing(new ZComparator()))));
    private final List<CustomFigure> repository = new ArrayList<>();

    private CustomRepository() {
    }

    public static CustomRepository getInstance() {
        if (instance == null) {
            instance = new CustomRepository();
        }
        return instance;
    }

    public void add(CustomFigure figure) {
        repository.add(figure);
    }

    public void remove(CustomFigure figure) {
        repository.remove(figure);
    }

    public void removeById(UUID id) {
        repository.removeIf(figure -> figure.getId() == id);
    }

    public boolean contains(CustomFigure figure) {
        return repository.contains(figure);
    }

    public void sort() {
        repository.sort(comparator);
    }

    public Object[] toArray() {
        return this.repository.toArray();
    }

    public void clear() {
        repository.clear();
    }

    public List<CustomFigure> query(Specification specification) {
        return repository.stream()
                .filter(o -> specification.specify(o))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomRepository{");
        sb.append("warehouse=").append(repository);
        sb.append('}');
        return sb.toString();
    }
}
