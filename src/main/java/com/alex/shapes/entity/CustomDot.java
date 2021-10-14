package com.alex.shapes.entity;

import java.util.Objects;

public class CustomDot {

    private double x;
    private double y;
    private double z;

    public CustomDot(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public CustomDot(){

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "CustomDot{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomDot customDot = (CustomDot) o;
        return Double.compare(customDot.x, x) == 0 &&
                Double.compare(customDot.y, y) == 0 &&
                Double.compare(customDot.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
