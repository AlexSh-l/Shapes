package com.alex.shape.specification.impl;

import com.alex.shape.entity.CustomFigure;
import com.alex.shape.specification.Specification;
import com.alex.shape.warehouse.CustomWarehouse;

import java.util.UUID;

public class SpecificationByVolume implements Specification {

    private double minimum;
    private double maximum;

    public SpecificationByVolume(double minimum, double maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    @Override
    public boolean specify(CustomFigure figure) {
        CustomWarehouse instance = CustomWarehouse.getInstance();
        UUID uuid = figure.getId();
        double volume = instance.get(uuid).getVolume();
        return (volume >= minimum) && (volume <= maximum);
    }
}
