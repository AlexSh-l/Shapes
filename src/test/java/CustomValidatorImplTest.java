import com.alex.shape.entity.CustomBall;
import com.alex.shape.validator.implementation.CustomValidatorImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomValidatorImplTest {

    private static CustomValidatorImpl validator;

    @BeforeClass
    public static void initializeValidator(){
        validator = new CustomValidatorImpl();
    }

    @Test
    public void validateArrayTest(){
        boolean isStringValid = validator.validateArray("-12 22 -32. 25.2");
        Assert.assertTrue(isStringValid);
    }

    @Test
    public void isObjectBallTest(){
        CustomBall ball = new CustomBall();
        ball.setBallRadius(1.0);
        boolean isStringValid = validator.isObjectBall(ball);
        Assert.assertTrue(isStringValid);
    }
}
