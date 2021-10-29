package com.alex.shape.entity;

public class FigureParameter {

    private double perimeter;
    private double square;
    private double volume;

    public FigureParameter(){

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
        final StringBuilder sb = new StringBuilder("FigureParameter{");
        sb.append("perimeter=").append(perimeter);
        sb.append(", square=").append(square);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FigureParameter that = (FigureParameter) o;

        if (Double.compare(that.perimeter, perimeter) != 0) return false;
        if (Double.compare(that.square, square) != 0) return false;
        return Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(perimeter);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(square);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
