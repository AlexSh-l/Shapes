package com.alex.shape.parser.implementation;

import com.alex.shape.parser.DataParser;
import com.alex.shape.validator.implementation.CustomValidatorImpl;

import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {

    @Override
    public double[] parseData(List<String> numbersListString) {
        ArrayList<Double> list = new ArrayList<>();
        int length = 0;
        if (numbersListString != null) {
            CustomValidatorImpl customValidator = new CustomValidatorImpl();
            for (String line : numbersListString) {
                if (customValidator.validateArray(line)) {
                    String stringNumber = customValidator.getMatcher().group();
                    String[] numbersString = stringNumber.split(REGEX_SPLITTER);
                    for (String number : numbersString) {
                        Double doubleNumber = Double.parseDouble(number);
                        list.add(doubleNumber);
                        length++;
                    }
                }
            }
        }
        double[] resultingArray = new double[length];
        int i = 0;
        for (double item : list) {
            resultingArray[i] = item;
            i++;
        }
        return resultingArray;
    }
}
