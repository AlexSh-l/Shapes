package com.alex.shapes.entity;

public class FigureFactory {

    public CustomFigure creteFigure(FigureType figureType){
        CustomFigure figure = null;
        switch (figureType){
            case BALL: figure = new CustomBall();
        }
        return figure;
    }
}
