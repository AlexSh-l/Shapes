package com.alex.shape.entity;

import java.util.UUID;

public abstract class CustomFigure {

    private UUID id;
    private String name;
    private CustomDot figureCenter;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CustomDot getFigureCenter() {
        return figureCenter;
    }

    protected void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFigureCenter(CustomDot figureCenter) {
        this.figureCenter = figureCenter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomFigure{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", figureCenter=").append(figureCenter);
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
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (figureCenter != null ? figureCenter.hashCode() : 0);
        return result;
    }
}
