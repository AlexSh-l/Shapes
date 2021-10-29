package com.alex.shape.validator.impl;

import com.alex.shape.entity.CustomBall;
import com.alex.shape.validator.CustomValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomValidatorImpl implements CustomValidator {

    private Matcher matcher;

    public Matcher getMatcher() {
        return matcher;
    }

    @Override
    public boolean validateArray(String line) {
        Pattern pattern = Pattern.compile(REGEX_NUMBERS);
        matcher = pattern.matcher(line);
        return matcher.find();
    }

    @Override
    public boolean isObjectBall(Object o) {
        if (o != null && o.getClass() == CustomBall.class) {
            return ((CustomBall) o).isBall();
        }
        return false;
    }
}
