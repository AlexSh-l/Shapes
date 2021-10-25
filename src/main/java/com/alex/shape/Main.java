package com.alex.shape;

import com.alex.shape.action.implementation.BallActions;
import com.alex.shape.entity.CustomBall;
import com.alex.shape.entity.CustomDot;
import com.alex.shape.entity.CustomFigure;
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
        CustomRepository repository = CustomRepository.getInstance();
        CustomDot center = new CustomDot(parsedData[0], parsedData[1], parsedData[2]);
        CustomBall ball = new CustomBall(4, "ball", center, parsedData[3]);
        repository.add(ball);
        logger.info(ball.toString());
        FigureFactory factory = FigureFactory.getInstance();
        CustomFigure figure = factory.creteFigure(FigureType.BALL);
        figure.setId(3);
        figure.setName("ball2");
        figure.setFigureCenter(center);
        repository.add(figure);
        CustomBall newBall = (CustomBall) figure;
        newBall.setBallRadius(4.0);
        BallActions actions = new BallActions();
        actions.perimeterCalculate(newBall);
        actions.squareCalculate(newBall);
        actions.volumeCalculate(newBall);
        logger.info(newBall.toString());
        ICustomObserver observer = new FigureObserver();
        newBall.attach(observer);
        newBall.setBallRadius(9.8);
        logger.info(newBall.toString());
        repository.sort();
        logger.info(repository.toString());
    }
}
