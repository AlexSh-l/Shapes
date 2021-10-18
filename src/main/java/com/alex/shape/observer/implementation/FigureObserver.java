package com.alex.shape.observer.implementation;

import com.alex.shape.action.implementation.BallActions;
import com.alex.shape.entity.CustomFigure;
import com.alex.shape.observer.FigureEvent;
import com.alex.shape.observer.ICustomObserver;
import com.alex.shape.repository.CustomRepository;

public class FigureObserver implements ICustomObserver {
    @Override
    public void parameterChanged(FigureEvent event) {
        CustomRepository repository = CustomRepository.getInstance();
        CustomFigure figure = event.getSource();
        repository.remove(figure);
        BallActions actions = new BallActions();
        actions.perimeterCalculate(figure);
        actions.squareCalculate(figure);
        actions.volumeCalculate(figure);
        repository.add(figure);
    }
}
