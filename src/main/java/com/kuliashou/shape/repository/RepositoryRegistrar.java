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
import com.kuliashou.shape.repository.exception.RepositoryException;
import com.kuliashou.shape.validator.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class RepositoryRegistrar implements ObservedRepository {

    private static Logger logger = LogManager.getLogger();

    private Map<Integer, Registrar> repositoryData;
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

    public Registrar findById(int id) throws RepositoryException {
        if (repositoryData.containsKey(id)) {
            return repositoryData.get(id);
        } else {
            throw new RepositoryException("Can't find data with Id " + id + ".");
        }
    }

    public Registrar update(Registrar registrar) throws RepositoryException {

        if (!repositoryData.containsValue(registrar)) {
            throw new RepositoryException("There is no value to update for value " + registrar + ".");

        }
        if (registrar == null) {
            throw new RepositoryException("Value can't be null.");
        }

        return repositoryData.put(registrar.getREGISTRAR_ID(), registrar);
    }

    public void create(Registrar registrar) throws RepositoryException {
        if (repositoryData.containsKey(registrar.getREGISTRAR_ID())) {
            throw new RepositoryException("A value for " + registrar.getREGISTRAR_ID() + " is already present.");
        }
        if (registrar == null) {
            throw new RepositoryException("Value cannot be null.");
        }

        repositoryData.put(registrar.getREGISTRAR_ID(), registrar);
    }

    public boolean delete(Registrar registrar) {
        return repositoryData.remove(registrar.getREGISTRAR_ID()) != null;
    }

    public LinkedHashMap<Integer, Registrar> sortById(HashMap<Integer, Registrar> unsortedData) {
        LinkedHashMap<Integer, Registrar> sortedData =
                unsortedData.entrySet().stream().sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedData;
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




