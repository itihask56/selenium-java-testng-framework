package com.itihas.api;

import com.itihas.auth.UserRole;
import com.itihas.factory.RequestSpecFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    private final RequestSpecification requestSpec;

    public ApiClient(UserRole role){
        this.requestSpec = RequestSpecFactory.create(role);
    }
    public Response post(String endpoint, Object body){
        return RestAssured
                .given()
                .spec(requestSpec)
                .body(body)
                .when()
                .post(endpoint);
    }

    public Response put(String endpoint,Object body){
        return RestAssured
                .given()
                .spec(requestSpec)
                .body(body)
                .when()
                .put(endpoint);
    }
    public Response get(String endpoint){
        return RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get(endpoint);
    }
}
