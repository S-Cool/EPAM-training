package com.kuliashou.shape.repository;

import com.kuliashou.shape.creator.Figure;
import com.kuliashou.shape.creator.FigureMaker;
import com.kuliashou.shape.creator.TriangleMaker;
import com.kuliashou.shape.exception.TriangleException;
import com.kuliashou.shape.listener.ObservedRepository;
import com.kuliashou.shape.listener.ObserverRepository;
import com.kuliashou.shape.parser.DataParser;
import com.kuliashou.shape.reader.DataReader;
import com.kuliashou.shape.registrar.Registrar;
import com.kuliashou.shape.registrar.RegistrarMaker;
import com.kuliashou.shape.validator.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositoryRegistrar implements ObservedRepository {

    private static Logger logger = LogManager.getLogger();

    private HashMap<Integer, Registrar> repositoryData;
    List<ObserverRepository> observers = new ArrayList<>();

    private static RepositoryRegistrar instance;

    private RepositoryRegistrar() {
    }

    public static RepositoryRegistrar getInstance() {
        if (instance == null) {
            instance = new RepositoryRegistrar();
        }
        return instance;
    }

    public void populateRepository(String filePath, String delimiter) {

        List<String> data = null;
        try {
            data = DataReader.readData(filePath);
        } catch (TriangleException e) {
            e.printStackTrace();
        }
        ArrayList validateData = Validate.validateData(data, delimiter);
        ArrayList<Double[]> dataParser = DataParser.dataParser(validateData, delimiter);
        FigureMaker figure = new TriangleMaker();
        HashMap<Integer, Figure> figures = figure.createFigures(dataParser);
        HashMap<Integer, Registrar> registrars = new RegistrarMaker().createRegistrars(figures);

        logger.info("The repository has populated!");
        repositoryData = registrars;
    }

    public Registrar findById(int id) {
        if (repositoryData.containsKey(id)) {
            return repositoryData.get(id);
        } else {
            logger.error("Data with ID " + id + " doesn't exist!");
            return null;
        }
    }

    public boolean update(Registrar registrar) {

        if (repositoryData.containsValue(registrar)) {
            repositoryData.replace(registrar.getTriangle().getTriangleId(), registrar);
            logger.error("The Data " + registrar + "has updated!");
            notifyObservers();
            return true;

        } else {
            logger.error("The Data for update doesn't exist!");
            return false;

        }
    }

    @Override
    public void addObserver(ObserverRepository observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverRepository observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ObserverRepository o : observers) {
            o.handleEvent(repositoryData);
        }
    }
}




