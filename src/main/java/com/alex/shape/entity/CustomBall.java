package com.alex.shape.entity;

import com.alex.shape.observer.FigureEvent;
import com.alex.shape.observer.ICustomObserver;
import com.alex.shape.observer.IObservable;

import java.util.ArrayList;
import java.util.List;

public class CustomBall extends CustomFigure implements IObservable {

    private double ballRadius;

    private List<ICustomObserver> observers = new ArrayList<>();

    public CustomBall(int id, String name, CustomDot center, double radius) {
        super.setId(id);
        super.setName(name);
        super.setFigureCenter(center);
        this.ballRadius = radius;
    }

    public CustomBall() {
    }

    public double getBallRadius() {
        return ballRadius;
    }

    public void setBallRadius(double ballRadius) {
        this.ballRadius = ballRadius;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        FigureEvent event = new FigureEvent(this);
        for (ICustomObserver observer : observers) {
            observer.parameterChanged(event);
        }
    }

    @Override
    public void attach(ICustomObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(ICustomObserver observer) {
        observers.remove(observer);
    }
}
