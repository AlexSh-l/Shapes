package com.alex.shape.entity;

import com.alex.shape.observer.FigureEvent;
import com.alex.shape.observer.CustomObserver;
import com.alex.shape.observer.Observable;

import java.util.ArrayList;
import java.util.List;

public class CustomBall extends CustomFigure implements Observable {

    private double ballRadius;
    private double volumeRatioXY;
    private double volumeRatioXZ;
    private double volumeRatioYZ;

    private final List<CustomObserver> observers = new ArrayList<>();

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

    public double getVolumeRatioXY() {
        return volumeRatioXY;
    }

    public double getVolumeRatioXZ() {
        return volumeRatioXZ;
    }

    public double getVolumeRatioYZ() {
        return volumeRatioYZ;
    }

    public void setBallRadius(double ballRadius) {
        this.ballRadius = ballRadius;
        notifyObservers();
    }

    public void setVolumeRatioXY(double volumeRatioXY) {
        this.volumeRatioXY = volumeRatioXY;
    }

    public void setVolumeRatioXZ(double volumeRatioXZ) {
        this.volumeRatioXZ = volumeRatioXZ;
    }

    public void setVolumeRatioYZ(double volumeRatioYZ) {
        this.volumeRatioYZ = volumeRatioYZ;
    }

    public boolean isBall() {
        return Double.compare(this.ballRadius, 0.0) > 0;
    }

    @Override
    public void notifyObservers() {
        FigureEvent event = new FigureEvent(this);
        for (CustomObserver observer : observers) {
            observer.parameterChanged(event);
        }
    }

    @Override
    public void attach(CustomObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(CustomObserver observer) {
        observers.remove(observer);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomFigure{");
        sb.append("id=").append(super.getId());
        sb.append(", name='").append(super.getName()).append('\'');
        sb.append(", figureCenter=").append(super.getFigureCenter());
        sb.append(", ballRadius=").append(ballRadius);
        sb.append(", perimeter=").append(super.getPerimeter());
        sb.append(", square=").append(super.getSquare());
        sb.append(", volume=").append(super.getVolume());
        sb.append(", volumeRatioXY=").append(volumeRatioXY);
        sb.append(", volumeRatioXZ=").append(volumeRatioXZ);
        sb.append(", volumeRatioYZ=").append(volumeRatioYZ);
        sb.append('}');
        return sb.toString();
    }
}
