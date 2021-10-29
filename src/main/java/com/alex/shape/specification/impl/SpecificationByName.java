package com.alex.shape.specification.impl;

import com.alex.shape.entity.CustomFigure;
import com.alex.shape.specification.Specification;

public class SpecificationByName implements Specification {

    private String name;

    public SpecificationByName(String name) {
        this.name = name;
    }

    @Override
    public boolean specify(CustomFigure figure) {
        return figure.getName().compareTo(name) == 0;
    }
}
