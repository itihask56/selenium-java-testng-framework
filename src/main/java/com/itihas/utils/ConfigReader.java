package com.itihas.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();
    static {
        String env = System.getProperty("env", "QA").toLowerCase();
        String fileName = "config/" + env + ".properties";

        try (FileInputStream file = new FileInputStream(fileName)) {
            properties.load(file);
            System.out.println("Loaded environment: " + env);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to load " + fileName, e
            );

        }

    }
    public static String get(String key){

        return properties.getProperty(key);

    }
    public static String getEnv(String key){
        return System.getenv(key);
    }

}