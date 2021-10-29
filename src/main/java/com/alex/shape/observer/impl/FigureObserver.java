package com.alex.shape.observer.impl;

import com.alex.shape.action.impl.BallActions;
import com.alex.shape.entity.CustomFigure;
import com.alex.shape.entity.FigureParameter;
import com.alex.shape.observer.FigureEvent;
import com.alex.shape.observer.CustomObserver;
import com.alex.shape.warehouse.CustomWarehouse;

public class FigureObserver implements CustomObserver {

    @Override
    public void parameterChanged(FigureEvent event) {
        CustomWarehouse warehouse = CustomWarehouse.getInstance();
        CustomFigure figure = event.getSource();
        BallActions actions = new BallActions();
        FigureParameter parameter = warehouse.get(figure.getId());
        double perimeter = actions.perimeterCalculate(figure);
        parameter.setPerimeter(perimeter);
        double square = actions.squareCalculate(figure);
        parameter.setSquare(square);
        double volume = actions.volumeCalculate(figure);
        parameter.setVolume(volume);
    }
}
