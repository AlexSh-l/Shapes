package com.alex.shape.specification.impl;

import com.alex.shape.entity.CustomFigure;
import com.alex.shape.specification.Specification;

import java.util.UUID;

public class SpecificationById implements Specification {

    private UUID id;

    public SpecificationById(UUID id) {
        this.id = id;
    }

    @Override
    public boolean specify(CustomFigure figure) {
        return figure.getId() == id;
    }
}
