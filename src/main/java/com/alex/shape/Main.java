package com.alex.shape;

import com.alex.shape.entity.CustomBall;
import com.alex.shape.entity.CustomDot;
import com.alex.shape.entity.factory.FigureFactory;
import com.alex.shape.entity.factory.FigureType;
import com.alex.shape.exception.FileReaderException;
import com.alex.shape.filereader.implementation.CustomFileReader;
import com.alex.shape.observer.ICustomObserver;
import com.alex.shape.observer.implementation.FigureObserver;
import com.alex.shape.parser.implementation.DataParser;
import com.alex.shape.repository.CustomRepository;
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
        } catch (FileReaderException e) {
            logger.error("FileReader exception", e);
        }
        DataParser dataParser = new DataParser();
        double[] parsedData = dataParser.parseData(fileContent);
        logger.info(Arrays.toString(parsedData));

        var repository = CustomRepository.getInstance();
        CustomDot dot = new CustomDot(2.0, 2.0, 2.0);
        CustomBall ball = new CustomBall(4, "ball", dot, 5.0);
        ball.setId(5);
        repository.add(ball);

        FigureFactory factory = FigureFactory.getInstance();
        var figure = factory.creteFigure(FigureType.BALL, 4.0);
        figure.setId(3);
        figure.setName("ball2");
        figure.setFigureCenter(dot);
        repository.add(figure);
        var newBall = (CustomBall) figure;
        ICustomObserver observer = new FigureObserver();
        newBall.attach(observer);
        newBall.setBallRadius(9.8);

        String figureString = figure.toString();
        int hash = figure.hashCode();

        var fl = repository.contains(null);
    }
}
