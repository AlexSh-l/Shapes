package com.alex.shape.action.implementation;

import com.alex.shape.action.FigureActions;
import com.alex.shape.entity.CustomBall;
import com.alex.shape.entity.CustomFigure;

public class BallActions implements FigureActions {

    @Override
    public void squareCalculate(CustomFigure figure) {
        CustomBall ball = (CustomBall) figure;
        figure.setSquare(4.0 * Math.PI * Math.pow(ball.getBallRadius(), 2.0));
    }

    @Override
    public void volumeCalculate(CustomFigure figure) {
        CustomBall ball = (CustomBall) figure;
        figure.setVolume(4.0 / 3.0 * Math.PI * Math.pow(ball.getBallRadius(), 3.0));
    }

    @Override
    public void perimeterCalculate(CustomFigure figure) {
        CustomBall ball = (CustomBall) figure;
        figure.setPerimeter(2.0 * Math.PI * ball.getBallRadius());
    }
}
