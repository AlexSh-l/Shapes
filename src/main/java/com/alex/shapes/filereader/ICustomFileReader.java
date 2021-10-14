package com.alex.shapes.filereader;

import com.alex.shapes.exception.FileReaderException;
import java.util.List;
import java.util.Optional;

public interface ICustomFileReader {

    String DEFAULT_FILE_PATH = "./data/numbers.txt";

    Optional<List<String>> readFile() throws FileReaderException;

    Optional<List<String>> readFile(String filePath) throws FileReaderException;
}
