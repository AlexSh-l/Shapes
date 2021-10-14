package com.alex.shapes.filereader.implementation;

import com.alex.shapes.exception.FileReaderException;
import com.alex.shapes.filereader.ICustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomFileReader implements ICustomFileReader {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Optional<List<String>> readFile() throws FileReaderException {
        Optional<List<String>> optionalFileContentList;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(DEFAULT_FILE_PATH))) {
            List<String> fileContentList = bufferedReader
                    .lines()
                    .collect(Collectors.toList());
            optionalFileContentList = Optional.of(fileContentList);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new FileReaderException("Unable to read from file", e);
        }
        return optionalFileContentList;
    }

    @Override
    public Optional<List<String>> readFile(String filePath) throws FileReaderException {
        Optional<List<String>> optionalFileContentList;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filePath))) {
            List<String> fileContentList = bufferedReader
                    .lines()
                    .collect(Collectors.toList());
            optionalFileContentList = Optional.of(fileContentList);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new FileReaderException("Unable to read from file", e);
        }
        return optionalFileContentList;
    }
}
