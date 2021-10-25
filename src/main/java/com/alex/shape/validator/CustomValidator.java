package com.alex.shape.validator;

public interface CustomValidator {

    String REGEX_NUMBERS = "^([\\-]?[\\d]+[\\.]?([ ]*))*$";

    boolean validateArray(String line);

    boolean isObjectBall(Object o);
}
