package com.itihas.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient extends ApiBase{
    public Response post(String endpoint, String payload){
        return RestAssured
                .given()
                .spec(REQUEST_SPEC)
                .body(payload)
                .when()
                .post(endpoint);
    }

    public Response put(String endpoint,String payload){
        return RestAssured
                .given()
                .spec(REQUEST_SPEC)
                .body(payload)
                .when()
                .put(endpoint);
    }
}
