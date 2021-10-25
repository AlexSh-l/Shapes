package com.alex.shape.entity;

public abstract class CustomFigure {

    private int id;
    private String name;
    private CustomDot figureCenter;
    private double perimeter;
    private double square;
    private double volume;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CustomDot getFigureCenter() {
        return figureCenter;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSquare() {
        return square;
    }

    public double getVolume() {
        return volume;
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

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomFigure{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", figureCenter=").append(figureCenter);
        sb.append(", perimeter=").append(perimeter);
        sb.append(", square=").append(square);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomFigure figure = (CustomFigure) o;
        if (id != figure.id) return false;
        if (name != null ? !name.equals(figure.name) : figure.name != null) return false;
        return figureCenter != null ? figureCenter.equals(figure.figureCenter) : figure.figureCenter == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (figureCenter != null ? figureCenter.hashCode() : 0);
        return result;
    }
}
