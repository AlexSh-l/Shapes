import com.alex.shape.comparator.*;
import com.alex.shape.entity.CustomBall;
import com.alex.shape.entity.CustomDot;
import com.alex.shape.entity.CustomFigure;
import com.alex.shape.repository.CustomRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomRepositoryTest {

    private static CustomRepository actual;
    private static List<CustomFigure> expected;

    @BeforeClass
    public static void initializeRepository() {
        expected = new ArrayList<>();
        actual = CustomRepository.getInstance();
        /*CustomFigure figure = factory.creteFigure(FigureType.BALL);
        ball = (CustomBall) figure;
        ball.setId(1);
        ball.setName("ball");
        ball.setFigureCenter(center);
        ball.setBallRadius(5.0);*/
    }

    @Test
    public void addTest() {
        expected.clear();
        CustomDot center = new CustomDot(2.0, 2.0, 2.0);
        actual.clear();
        CustomBall ball = new CustomBall(2, "ball", center, 5);
        actual.add(ball);
        expected.add(ball);
        ball = new CustomBall(1, "ball2", center, 7);
        actual.add(ball);
        expected.add(ball);
        center = new CustomDot(5.0, 3.0, 9.2);
        ball = new CustomBall(5, "ball3", center, 9);
        actual.add(ball);
        expected.add(ball);
        boolean areContentsEqual = Arrays.deepEquals(expected.toArray(), actual.toArray());
        Assert.assertTrue(areContentsEqual);
    }

    @Test
    public void removeTest() {
        expected.clear();
        CustomDot center = new CustomDot(2.0, 2.0, 2.0);
        actual.clear();
        CustomBall ball = new CustomBall(2, "ball", center, 5);
        actual.add(ball);
        expected.add(ball);
        ball = new CustomBall(1, "ball2", center, 7);
        actual.add(ball);
        actual.remove(ball);
        boolean areContentsEqual = Arrays.deepEquals(expected.toArray(), actual.toArray());
        Assert.assertTrue(areContentsEqual);
    }

    @Test
    public void containsTest() {
        actual.clear();
        CustomDot center = new CustomDot(2.0, 2.0, 2.0);
        CustomBall ball = new CustomBall(2, "ball", center, 5);
        actual.add(ball);
        Assert.assertTrue(actual.contains(ball));
    }

    @Test
    public void sortTest() {
        expected.clear();
        Comparator<CustomFigure> comparator = new IdComparator()
                .thenComparing(new NameComparator()
                        .thenComparing(new XComparator()
                                .thenComparing(new YComparator()
                                        .thenComparing(new ZComparator()
                                                .thenComparing(new PerimeterComparator()
                                                        .thenComparing(new SquareComparator()
                                                                .thenComparing(new VolumeComparator())))))));
        CustomDot center = new CustomDot(2.0, 2.0, 2.0);
        actual.clear();
        CustomBall ball = new CustomBall(2, "ball", center, 5);
        actual.add(ball);
        expected.add(ball);
        ball = new CustomBall(1, "ball2", center, 7);
        actual.add(ball);
        expected.add(ball);
        actual.sort();
        expected.sort(comparator);
        boolean areContentsEqual = Arrays.deepEquals(expected.toArray(), actual.toArray());
        Assert.assertTrue(areContentsEqual);
    }
}
