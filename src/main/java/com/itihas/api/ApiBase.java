package com.itihas.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

    protected static final String BASE_URL =
            "https://api.emoha.com/api/v1/crm";

    protected static final String TOKEN =
            "Bearer YOUR_TOKEN";

    protected static final RequestSpecification REQUEST_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri(BASE_URL)
                    .addHeader("Authorization", TOKEN)
                    .setContentType(ContentType.JSON)
                    .build();
}