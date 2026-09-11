package com.itihas.api;

import com.itihas.filter.ApiLoggingFilter;
import com.itihas.utils.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

    protected static final String BASE_URL = ConfigReader.get("api.base.url");

//    protected static final String TOKEN = ConfigReader.getEnv("API_TOKEN");
    protected static final String ENV = System.getProperty("env", "QA");

    protected static final String TOKEN = ConfigReader.getEnv(ENV.toUpperCase() + "_API_TOKEN");

    static {
        System.out.println(
                "Environment = "
                        + System.getProperty("env")
        );

        System.out.println(
                "Token found = "
                        + (TOKEN != null)
        );
        if (TOKEN == null || TOKEN.isBlank()) {
            throw new RuntimeException(
                    "API_TOKEN environment variable not found"
            );
        }
        if (TOKEN != null) {
            System.out.println(
                    "Token Length = " +
                            TOKEN.length()
            );

            System.out.println(
                    "Starts With Bearer = " +
                            TOKEN.startsWith("Bearer ")
            );
        }
    }

    protected static final RequestSpecification REQUEST_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri(BASE_URL)
                    .addHeader("Authorization", TOKEN)
                    .setContentType(ContentType.JSON)
                    .addFilter(new ApiLoggingFilter())
                    .build();
}