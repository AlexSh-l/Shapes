package com.alex.shape.specification.impl;

import com.alex.shape.entity.CustomDot;
import com.alex.shape.entity.CustomFigure;
import com.alex.shape.specification.Specification;

public class SpecificationByX implements Specification {

    private double minimum;
    private double maximum;

    public SpecificationByX(double maximum, double minimum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    @Override
    public boolean specify(CustomFigure figure) {
        CustomDot center = figure.getFigureCenter();
        double xCenter = center.getX();
        return (xCenter >= minimum) && (xCenter <= maximum);
    }
}
