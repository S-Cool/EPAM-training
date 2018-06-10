package com.kuliashou.shape.reader;

import com.kuliashou.shape.exception.TriangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {

    private static Logger logger = LogManager.getLogger();

    public static List<String> readData(String filePath) throws TriangleException {

        if (filePath == null || filePath.isEmpty() || !new File(filePath).exists()) {
            throw new TriangleException("Wrong path or file doesn't exist!");
        }

        List<String> list;

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {

            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            logger.fatal("Can't open file " + filePath);
            throw new TriangleException("Can't open file", e);
        }

        logger.info("File has findById!");
        return list;

    }

}
