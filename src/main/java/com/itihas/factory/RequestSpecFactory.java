package com.itihas.factory;

import com.itihas.auth.TokenManager;
import com.itihas.auth.UserRole;
import com.itihas.filter.ApiLoggingFilter;
import com.itihas.utils.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {

    private RequestSpecFactory(){}

    public static RequestSpecification create(UserRole role){

        String baseUrl =
                ConfigReader.get("api.base.url");

        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addHeader(
                        "Authorization",
                        TokenManager.getToken(role)
                )
                .setContentType(ContentType.JSON)
                .addFilter(new ApiLoggingFilter())
                .build();
    }
}