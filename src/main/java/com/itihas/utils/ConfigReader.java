package com.itihas.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();
    static {

        try {

            FileInputStream file =
                    new FileInputStream(
                            "config/config.properties"
                    );

            properties.load(file);

        }

        catch (IOException e){

            throw new RuntimeException(
                    "Unable to load config.properties",
                    e
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