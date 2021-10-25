package com.alex.shape.comparator;

import com.alex.shape.entity.CustomFigure;

import java.util.Comparator;

public class XComparator implements Comparator<CustomFigure> {
    @Override
    public int compare(CustomFigure figure1, CustomFigure figure2) {
        if ((figure1 == null) && (figure2 == null)) {
            return 0;
        } else if (figure1 == null) {
            return -1;
        } else if (figure2 == null) {
            return 1;
        }
        double figure1CenterX = figure1.getFigureCenter().getX();
        double figure2CenterX = figure2.getFigureCenter().getX();
        return Double.compare(figure1CenterX, figure2CenterX);
    }
}
