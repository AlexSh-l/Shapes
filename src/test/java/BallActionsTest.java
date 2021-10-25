import com.alex.shape.action.implementation.BallActions;
import com.alex.shape.entity.CustomBall;
import com.alex.shape.entity.CustomDot;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BallActionsTest {

    private static BallActions actions;
    private static CustomBall ball;

    @BeforeClass
    public static void initializeFigure() {
        CustomDot center = new CustomDot(2.0, 2.0, 2.0);
        ball = new CustomBall(1, "ball", center, 5);
        actions = new BallActions();
    }

    @Test
    public void squareCalculateTest() {
        actions.squareCalculate(ball);
        double expected = 314.15927;
        double actual = ball.getSquare();
        Assert.assertEquals(expected, actual, 0.5);
    }

    @Test
    public void volumeCalculateTest() {
        actions.volumeCalculate(ball);
        double expected = 523.59878;
        double actual = ball.getVolume();
        Assert.assertEquals(expected, actual, 0.5);
    }

    @Test
    public void perimeterCalculateTest() {
        actions.perimeterCalculate(ball);
        double expected = 31.41593;
        double actual = ball.getPerimeter();
        Assert.assertEquals(expected, actual, 0.5);
    }

    @Test
    public void volumeRatioXYTest() {
        actions.volumeRatioXY(ball);
        double expected = -1.0;
        double actual = ball.getVolumeRatioXY();
        Assert.assertEquals(expected, actual, 0.5);
    }

    @Test
    public void volumeRatioXZTest() {
        actions.volumeRatioXZ(ball);
        double expected = -1.0;
        double actual = ball.getVolumeRatioXZ();
        Assert.assertEquals(expected, actual, 0.5);
    }

    @Test
    public void volumeRatioYZTest() {
        actions.volumeRatioYZ(ball);
        double expected = -1.0;
        double actual = ball.getVolumeRatioYZ();
        Assert.assertEquals(expected, actual, 0.5);
    }

    @Test
    public void isTouchingXYTest() {
        boolean result = actions.isTouchingXY(ball);
        Assert.assertFalse(result);
    }

    @Test
    public void isTouchingXZTest() {
        ball.setBallRadius(2.0);
        boolean result = actions.isTouchingXZ(ball);
        Assert.assertTrue(result);
    }

    @Test
    public void isTouchingYZTest() {
        ball.setBallRadius(1.0);
        boolean result = actions.isTouchingYZ(ball);
        Assert.assertFalse(result);
    }
}
