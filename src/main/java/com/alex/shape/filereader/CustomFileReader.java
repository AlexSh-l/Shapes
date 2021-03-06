package com.alex.shape.filereader;

import com.alex.shape.exception.FileReaderException;

import java.util.List;
import java.util.Optional;

public interface CustomFileReader {

    String DEFAULT_FILE_PATH = "./data/numbers.txt";

    Optional<List<String>> readFile() throws FileReaderException;

    Optional<List<String>> readFile(String filePath) throws FileReaderException;
}
