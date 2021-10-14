package com.alex.shapes.entity;

import java.util.Objects;

public class CustomFigure {

    private int id;

    private String name;

    private CustomDot figureCenter;

    private double ballRadius;

    public CustomFigure(int id, String name, CustomDot center, double radius) {
        this.id = id;
        this.name = name;
        this.figureCenter = center;
        this.ballRadius = radius;
    }

    public CustomFigure(){
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CustomDot getFigureCenter() {
        return figureCenter;
    }

    public double getBallRadius() {
        return ballRadius;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFigureCenter(CustomDot figureCenter) {
        this.figureCenter = figureCenter;
    }

    public void setBallRadius(double ballRadius) {
        this.ballRadius = ballRadius;
    }

    @Override
    public String toString() {
        return "CustomBall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomFigure that = (CustomFigure) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
