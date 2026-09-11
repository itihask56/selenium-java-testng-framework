package com.itihas.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient extends ApiBase{
    public Response post(String endpoint, Object body){
        return RestAssured
                .given()
                .spec(REQUEST_SPEC)
                .body(body)
                .when()
                .post(endpoint);
    }

    public Response put(String endpoint,Object body){
        return RestAssured
                .given()
                .spec(REQUEST_SPEC)
                .body(body)
                .when()
                .put(endpoint);
    }
}
