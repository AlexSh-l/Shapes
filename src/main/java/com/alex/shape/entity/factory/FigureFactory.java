package com.alex.shape.entity.factory;

import com.alex.shape.entity.CustomBall;
import com.alex.shape.entity.CustomFigure;

public class FigureFactory {

    private static FigureFactory instance;

    private FigureFactory() {
    }

    public static FigureFactory getInstance() {
        if (instance == null) {
            instance = new FigureFactory();
        }
        return instance;
    }

    public CustomFigure creteFigure(FigureType figureType) {
        switch (figureType) {
            case BALL:
                return new CustomBall();
        }
        return null;
    }
}
