package com.alex.shapes.parser.implementation;

import com.alex.shapes.parser.IDataParser;
import com.alex.shapes.validator.implementation.CustomValidator;
import java.util.ArrayList;
import java.util.List;

public class DataParser implements IDataParser {

    @Override
    public int[] parseData(List<String> numbersListString)  {
        ArrayList<Integer> list = new ArrayList<>();
        int length = 0;
        if(numbersListString != null) {
            CustomValidator customValidator = new CustomValidator();
            for (String line : numbersListString) {
                if (customValidator.validateArray(line)) {
                    String stringNumber = customValidator.matcher.group();
                    String[] numbersString = stringNumber.split(REGEX_SPLITTER);
                    for (String number : numbersString) {
                        Integer integerNumber = Integer.parseInt(number);
                        list.add(integerNumber);
                        length++;
                    }
                }
            }
        }
        int[] resultingArray = new int[length];
        int i = 0;
        for(int item : list){
            resultingArray[i] = item;
            i++;
        }
        return resultingArray;
    }
}
