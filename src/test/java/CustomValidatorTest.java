import com.alex.shape.entity.CustomBall;
import com.alex.shape.validator.implementation.CustomValidator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomValidatorTest {

    private static CustomValidator validator;

    @BeforeClass
    public static void initializeValidator(){
        validator = new CustomValidator();
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
