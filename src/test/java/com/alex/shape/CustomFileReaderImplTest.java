package com.alex.shape;

import com.alex.shape.exception.FileReaderException;
import com.alex.shape.filereader.impl.CustomFileReaderImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CustomFileReaderImplTest {

    private static List<String> list;

    @BeforeClass
    public static void initializeList() {
        list = new ArrayList<>();
        list.add("regrevah8r3r");
        list.add("-12 22 -32. 25.2");
        list.add("23r5");
        list.add("3.0 4.2 -5.13 67..  -898.3");
        list.add("re");
        list.add("gr");
    }

    @Test
    public void readFileTest() {
        CustomFileReaderImpl customFileReader = new CustomFileReaderImpl();
        try {
            List<String> expected = list;
            if (customFileReader.readFile().isPresent()) {
                List<String> actual = customFileReader.readFile().get();
                Assert.assertEquals(expected, actual);
            } else {
                Assert.fail("readFileTest failed");
            }
        } catch (FileReaderException e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
