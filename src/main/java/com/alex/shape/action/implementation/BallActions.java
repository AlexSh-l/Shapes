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

    public void volumeRatioXY(CustomFigure figure) {
        CustomBall ball = (CustomBall) figure;
        double volumeRatio;
        double ballCenterZ = ball.getFigureCenter().getZ();
        if (Double.compare(ballCenterZ, 0.0) > 0) {
            double segmentHeight = ballCenterZ - ball.getBallRadius();
            if (segmentHeight < 0) {
                double segmentVolume = Math.PI * Math.pow(segmentHeight, 2) * (3 * ball.getBallRadius() - segmentHeight) / 3;
                volumeRatio = segmentVolume / (ball.getVolume() - segmentVolume);
                ball.setVolumeRatioXY(volumeRatio);
            }
        } else if (Double.compare(ballCenterZ, 0.0) < 0) {
            double segmentHeight = ballCenterZ + ball.getBallRadius();
            if (segmentHeight > 0) {
                double segmentVolume = Math.PI * Math.pow(segmentHeight, 2) * (3 * ball.getBallRadius() - segmentHeight) / 3;
                volumeRatio = segmentVolume / (ball.getVolume() - segmentVolume);
                ball.setVolumeRatioXY(volumeRatio);
            }
        } else if (Double.compare(ballCenterZ, 0.0) == 0) {
            volumeRatio = 1.0;
            ball.setVolumeRatioXY(volumeRatio);
        }
    }

    public void volumeRatioXZ(CustomFigure figure) {
        CustomBall ball = (CustomBall) figure;
        double volumeRatio;
        double ballCenterY = ball.getFigureCenter().getY();
        if (Double.compare(ballCenterY, 0.0) > 0) {
            double segmentHeight = ballCenterY - ball.getBallRadius();
            if (segmentHeight < 0) {
                double segmentVolume = Math.PI * Math.pow(segmentHeight, 2) * (3 * ball.getBallRadius() - segmentHeight) / 3;
                volumeRatio = segmentVolume / (ball.getVolume() - segmentVolume);
                ball.setVolumeRatioXZ(volumeRatio);
            }
        } else if (Double.compare(ballCenterY, 0.0) < 0) {
            double segmentHeight = ballCenterY + ball.getBallRadius();
            if (segmentHeight > 0) {
                double segmentVolume = Math.PI * Math.pow(segmentHeight, 2) * (3 * ball.getBallRadius() - segmentHeight) / 3;
                volumeRatio = segmentVolume / (ball.getVolume() - segmentVolume);
                ball.setVolumeRatioXZ(volumeRatio);
            }
        } else if (Double.compare(ballCenterY, 0.0) == 0) {
            volumeRatio = 1.0;
            ball.setVolumeRatioXZ(volumeRatio);
        }
    }

    public void volumeRatioYZ(CustomFigure figure) {
        CustomBall ball = (CustomBall) figure;
        double volumeRatio;
        double ballCenterX = ball.getFigureCenter().getX();
        if (Double.compare(ballCenterX, 0.0) > 0) {
            double segmentHeight = ballCenterX - ball.getBallRadius();
            if (segmentHeight < 0) {
                double segmentVolume = Math.PI * Math.pow(segmentHeight, 2) * (3 * ball.getBallRadius() - segmentHeight) / 3;
                volumeRatio = segmentVolume / (ball.getVolume() - segmentVolume);
                ball.setVolumeRatioYZ(volumeRatio);
            }
        } else if (Double.compare(ballCenterX, 0.0) < 0) {
            double segmentHeight = ballCenterX + ball.getBallRadius();
            if (segmentHeight > 0) {
                double segmentVolume = Math.PI * Math.pow(segmentHeight, 2) * (3 * ball.getBallRadius() - segmentHeight) / 3;
                volumeRatio = segmentVolume / (ball.getVolume() - segmentVolume);
                ball.setVolumeRatioYZ(volumeRatio);
            }
        } else if (Double.compare(ballCenterX, 0.0) == 0) {
            volumeRatio = 1.0;
            ball.setVolumeRatioYZ(volumeRatio);
        }
    }

    public boolean isTouchingXY(CustomFigure figure) {
        CustomBall ball = (CustomBall) figure;
        boolean isTouching = false;
        double ballCenterZ = ball.getFigureCenter().getZ();
        if ((Double.compare(ballCenterZ, 0.0) < 0) && (Double.compare(ballCenterZ, (ball.getBallRadius() * -1)) == 0)) {
            isTouching = true;
        } else if ((Double.compare(ballCenterZ, 0.0) > 0) && (Double.compare(ballCenterZ, ball.getBallRadius()) == 0)) {
            isTouching = true;
        }
        return isTouching;
    }

    public boolean isTouchingXZ(CustomFigure figure) {
        CustomBall ball = (CustomBall) figure;
        boolean isTouching = false;
        double ballCenterY = ball.getFigureCenter().getY();
        if ((Double.compare(ballCenterY, 0.0) < 0) && (Double.compare(ballCenterY, (ball.getBallRadius() * -1)) == 0)) {
            isTouching = true;
        } else if ((Double.compare(ballCenterY, 0.0) > 0) && (Double.compare(ballCenterY, ball.getBallRadius()) == 0)) {
            isTouching = true;
        }
        return isTouching;
    }

    public boolean isTouchingYZ(CustomFigure figure) {
        CustomBall ball = (CustomBall) figure;
        boolean isTouching = false;
        double ballCenterX = ball.getFigureCenter().getX();
        if ((Double.compare(ballCenterX, 0.0) < 0) && (Double.compare(ballCenterX, (ball.getBallRadius() * -1)) == 0)) {
            isTouching = true;
        } else if ((Double.compare(ballCenterX, 0.0) > 0) && (Double.compare(ballCenterX, ball.getBallRadius()) == 0)) {
            isTouching = true;
        }
        return isTouching;
    }
}
