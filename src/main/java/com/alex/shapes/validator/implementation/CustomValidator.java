package com.alex.shapes.validator.implementation;

import com.alex.shapes.validator.ICustomValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomValidator implements ICustomValidator {

    public Matcher matcher;

    @Override
    public boolean validateArray(String line){
        Pattern pattern = Pattern.compile(REGEX_NUMBERS);
        matcher = pattern.matcher(line);
        return matcher.find();
    }
}
