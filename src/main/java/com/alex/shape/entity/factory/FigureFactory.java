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

    public CustomFigure creteFigure(FigureType figureType, double... params) {
        switch (figureType) {
            case BALL:
                CustomBall ball = new CustomBall();
                if (params.length > 0) {
                    ball.setBallRadius(params[0]);
                }
                return ball;
        }
        return null;
    }
}
