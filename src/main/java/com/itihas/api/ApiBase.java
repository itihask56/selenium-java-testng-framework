package com.itihas.api;

import com.itihas.utils.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

    protected static final String BASE_URL = ConfigReader.get("api.base.url");

    protected static final String TOKEN = ConfigReader.getEnv("API_TOKEN");

    protected static final RequestSpecification REQUEST_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri(BASE_URL)
                    .addHeader("Authorization", TOKEN)
                    .setContentType(ContentType.JSON)
                    .build();
}