package com.alex.shape.parser;

import java.util.List;

public interface DataParser {

    String REGEX_SPLITTER = "\\s+";

    double[] parseData(List<String> numbersListString);
}
