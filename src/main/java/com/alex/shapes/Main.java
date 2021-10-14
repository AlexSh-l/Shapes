package com.alex.shapes;

import com.alex.shapes.exception.FileReaderException;
import com.alex.shapes.filereader.implementation.CustomFileReader;
import com.alex.shapes.parser.implementation.DataParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        List<String> fileContent = new ArrayList<>();
        CustomFileReader fileReader = new CustomFileReader();
        try {
            fileContent = fileReader.readFile().get();
        }catch (FileReaderException e){
            logger.error("FileReader exception", e);
        }
        DataParser dataParser = new DataParser();
        int[] parsedData = dataParser.parseData(fileContent);
        logger.info(Arrays.toString(parsedData));

    }
}
