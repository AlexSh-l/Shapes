package com.alex.shapes.parser;

import java.util.List;

public interface IDataParser {

    String REGEX_SPLITTER = "\\s+";

    int[] parseData(List<String> numbersListString);
}
