package com.alex.shape.parser.implementation;

import com.alex.shape.parser.IDataParser;
import com.alex.shape.validator.implementation.CustomValidator;

import java.util.ArrayList;
import java.util.List;

public class DataParser implements IDataParser {

    @Override
    public double[] parseData(List<String> numbersListString) {
        ArrayList<Double> list = new ArrayList<>();
        int length = 0;
        if (numbersListString != null) {
            CustomValidator customValidator = new CustomValidator();
            for (String line : numbersListString) {
                if (customValidator.validateArray(line)) {
                    String stringNumber = customValidator.matcher.group();
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
