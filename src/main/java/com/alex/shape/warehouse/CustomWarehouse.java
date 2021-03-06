package com.alex.shape.warehouse;

import com.alex.shape.action.FigureActions;
import com.alex.shape.action.impl.BallActions;
import com.alex.shape.entity.CustomFigure;
import com.alex.shape.entity.FigureParameter;

import java.util.HashMap;
import java.util.UUID;

public class CustomWarehouse {

    private static CustomWarehouse instance;
    private final HashMap<UUID, FigureParameter> warehouse = new HashMap<>();

    private CustomWarehouse() {

    }

    public static CustomWarehouse getInstance() {
        if (instance == null) {
            instance = new CustomWarehouse();
        }
        return instance;
    }

    public void put(UUID uuid, FigureParameter figureParameter) {
        warehouse.put(uuid, figureParameter);
    }

    public void put(CustomFigure figure) {
        FigureActions actions = new BallActions();
        FigureParameter figureParameter = new FigureParameter();
        double perimeter = actions.perimeterCalculate(figure);
        figureParameter.setPerimeter(perimeter);
        double square = actions.squareCalculate(figure);
        figureParameter.setSquare(square);
        double volume = actions.volumeCalculate(figure);
        figureParameter.setVolume(volume);
        this.put(figure.getId(), figureParameter);
    }

    public FigureParameter get(UUID uuid) {
        return warehouse.get(uuid);
    }

    public void remove(UUID uuid, FigureParameter figureParameter) {
        warehouse.remove(uuid, figureParameter);
    }

    public void remove(UUID uuid) {
        warehouse.remove(uuid);
    }

    public void clear() {
        warehouse.clear();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomWarehouse{");
        sb.append("map=").append(warehouse);
        sb.append('}');
        return sb.toString();
    }
}
