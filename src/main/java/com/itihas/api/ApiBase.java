package com.itihas.api;

import com.itihas.utils.ConfigReader;

public class ApiBase {

    protected static final String ENV =
            System.getProperty("env", "qa").toLowerCase();

    protected static final String BASE_URL =
            ConfigReader.get("api.base.url");

    static {

        System.out.println("Environment = " + ENV);
        System.out.println("Base URL = " + BASE_URL);

        if (BASE_URL == null || BASE_URL.isBlank()) {
            throw new RuntimeException(
                    "api.base.url not found for environment: " + ENV
            );
        }
    }
}