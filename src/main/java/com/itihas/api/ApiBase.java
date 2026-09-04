package com.itihas.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

    protected static final String BASE_URL =
            "https://api.emoha.com/api/v1/crm";

    protected static final String TOKEN =
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MzYzNzM4LCJwYXNzd29yZF9sYXN0X3VwZGF0ZWRfYXQiOiIyMDI2LTAxLTA5IDE3OjQ1OjM5IiwiaWF0IjoxNzg4MzM5NDI3LCJleHAiOjE3OTA5MzE0Mjd9.-ywTjiZPheFewGXAVcv97iGnUVjkRVVw8aN1II7Ym88";

    protected static final RequestSpecification REQUEST_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri(BASE_URL)
                    .addHeader("Authorization", TOKEN)
                    .setContentType(ContentType.JSON)
                    .build();
}