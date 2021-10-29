package com.alex.shape;

import com.alex.shape.action.impl.BallActions;
import com.alex.shape.entity.CustomBall;
import com.alex.shape.entity.CustomDot;
import com.alex.shape.warehouse.CustomWarehouse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BallActionsTest {

    private static BallActions actions;
    private static CustomBall ball;
    private static CustomDot center;
    private static CustomWarehouse instance;

    @BeforeClass
    public static void initializeFigure() {
        center = new CustomDot(2.0, 2.0, 2.0);
        actions = new BallActions();
        instance = CustomWarehouse.getInstance();
    }

    @Test
    public void squareCalculateTest() {
        ball = new CustomBall("ball", center, 5);
        double expected = 314.15927;
        double actual = actions.squareCalculate(ball);
        Assert.assertEquals(expected, actual, 0.5);
    }

    @Test
    public void volumeCalculateTest() {
        ball = new CustomBall("ball", center, 5);
        double expected = 523.59878;
        double actual = actions.volumeCalculate(ball);
        Assert.assertEquals(expected, actual, 0.5);
    }

    @Test
    public void perimeterCalculateTest() {
        ball = new CustomBall("ball", center, 5);
        double expected = 31.41593;
        double actual = actions.perimeterCalculate(ball);
        Assert.assertEquals(expected, actual, 0.5);
    }

    @Test
    public void volumeRatioXYTest() {
        ball = new CustomBall("ball", center, 5);
        instance.put(ball);
        actions.volumeRatioXY(ball);
        double expected = 0.47929;
        double actual = ball.getVolumeRatioXY();
        instance.remove(ball.getId());
        Assert.assertEquals(expected, actual, 0.5);
    }

    @Test
    public void volumeRatioXZTest() {
        ball = new CustomBall("ball", center, 5);
        instance.put(ball);
        actions.volumeRatioXZ(ball);
        double expected = 0.47929;
        double actual = ball.getVolumeRatioXZ();
        instance.remove(ball.getId());
        Assert.assertEquals(expected, actual, 0.5);
    }

    @Test
    public void volumeRatioYZTest() {
        ball = new CustomBall("ball", center, 5);
        instance.put(ball);
        actions.volumeRatioYZ(ball);
        double expected = 0.47929;
        double actual = ball.getVolumeRatioYZ();
        instance.remove(ball.getId());
        Assert.assertEquals(expected, actual, 0.5);
    }

    @Test
    public void isTouchingXYTest() {
        ball = new CustomBall("ball", center, 5);
        boolean result = actions.isTouchingXY(ball);
        Assert.assertFalse(result);
    }

    @Test
    public void isTouchingXZTest() {
        ball = new CustomBall("ball", center, 5);
        ball.setBallRadius(2.0);
        boolean result = actions.isTouchingXZ(ball);
        Assert.assertTrue(result);
    }

    @Test
    public void isTouchingYZTest() {
        ball = new CustomBall("ball", center, 5);
        ball.setBallRadius(1.0);
        boolean result = actions.isTouchingYZ(ball);
        Assert.assertFalse(result);
    }
}
