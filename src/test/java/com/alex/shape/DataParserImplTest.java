package com.alex.shape;

import com.alex.shape.parser.impl.DataParserImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataParserImplTest {

    private static List<String> data;
    private static double[] array;

    @BeforeClass
    public static void initializeList() {
        data = new ArrayList<>();
        data.add("regrevah8r3r");
        data.add("-12 22 -32. 25.2");
        data.add("23r5");
        data.add("3.0 4.2 -5.13 67..  -898.3");
        data.add("re");
        data.add("gr");
        array = new double[]{-12.0, 22.0, -32.0, 25.2};
    }

    @Test
    public void parseDataTest() {
        DataParserImpl parser = new DataParserImpl();
        double[] expected = array;
        double[] actual = parser.parseData(data);
        Assert.assertArrayEquals(expected, actual, 0.5);
    }
}
