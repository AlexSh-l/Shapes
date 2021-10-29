package com.alex.shape.action;

import com.alex.shape.entity.CustomFigure;

public interface FigureActions {

    double squareCalculate(CustomFigure figure);

    double volumeCalculate(CustomFigure figure);

    double perimeterCalculate(CustomFigure figure);
}
