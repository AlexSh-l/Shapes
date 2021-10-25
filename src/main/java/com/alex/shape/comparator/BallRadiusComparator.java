package com.alex.shape.comparator;

import com.alex.shape.entity.CustomBall;

import java.util.Comparator;

public class BallRadiusComparator implements Comparator<CustomBall> {
    @Override
    public int compare(CustomBall ball1, CustomBall ball2) {
        if ((ball1 == null) && (ball2 == null)) {
            return 0;
        } else if (ball1 == null) {
            return -1;
        } else if (ball2 == null) {
            return 1;
        }
        double ball1Radius = ball1.getBallRadius();
        double ball2Radius = ball2.getBallRadius();
        return Double.compare(ball1Radius, ball2Radius);
    }
}
