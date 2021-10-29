package com.alex.shape;

import com.alex.shape.entity.CustomBall;
import com.alex.shape.entity.CustomDot;
import com.alex.shape.entity.CustomFigure;
import com.alex.shape.entity.FigureParameter;
import com.alex.shape.entity.factory.FigureFactory;
import com.alex.shape.entity.factory.FigureType;
import com.alex.shape.exception.FileReaderException;
import com.alex.shape.filereader.impl.CustomFileReaderImpl;
import com.alex.shape.observer.CustomObserver;
import com.alex.shape.observer.impl.FigureObserver;
import com.alex.shape.parser.impl.DataParserImpl;
import com.alex.shape.repository.CustomRepository;
import com.alex.shape.specification.Specification;
import com.alex.shape.specification.impl.SpecificationByName;
import com.alex.shape.warehouse.CustomWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        List<String> fileContent = new ArrayList<>();
        CustomFileReaderImpl fileReader = new CustomFileReaderImpl();
        try {
            fileContent = fileReader.readFile().get();
        } catch (FileReaderException e) {
            logger.error("FileReader exception", e);
        }
        DataParserImpl dataParser = new DataParserImpl();
        double[] parsedData = dataParser.parseData(fileContent);
        logger.info(Arrays.toString(parsedData));
        CustomRepository repository = CustomRepository.getInstance();
        CustomWarehouse warehouse = CustomWarehouse.getInstance();
        FigureParameter figureParameter = new FigureParameter();
        CustomDot center = new CustomDot(parsedData[0], parsedData[1], parsedData[2]);
        CustomBall ball = new CustomBall("ball", center, parsedData[3]);
        repository.add(ball);
        logger.info(ball.toString());
        FigureFactory factory = FigureFactory.getInstance();
        CustomFigure figure = factory.creteFigure(FigureType.BALL);
        figure.setName("ball2");
        figure.setFigureCenter(center);
        repository.add(figure);
        CustomBall newBall = (CustomBall) figure;
        newBall.setBallRadius(4.0);
        warehouse.put(newBall);
        logger.info(warehouse.toString());
        CustomObserver observer = new FigureObserver();
        newBall.attach(observer);
        newBall.setBallRadius(9.8);
        logger.info(newBall.toString());
        repository.sort();
        logger.info(repository.toString());
        Specification specificationByName = new SpecificationByName("ball");
        List<CustomFigure> figureQuerryBall = repository.query(specificationByName);
        logger.info(figureQuerryBall.toString());
    }
}
