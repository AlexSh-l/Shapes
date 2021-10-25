package com.alex.shape.validator;

public interface ICustomValidator {

    String REGEX_NUMBERS = "^([\\-]?[\\d]+[\\.]?([ ]*))*$";

    boolean validateArray(String line);

    boolean isObjectBall(Object o);
}
