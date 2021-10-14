package com.alex.shapes.validator;

public interface ICustomValidator {

    String REGEX_NUMBERS = "^([\\-]?[\\d]+([ ]*))*$";

    boolean validateArray(String line);
}
