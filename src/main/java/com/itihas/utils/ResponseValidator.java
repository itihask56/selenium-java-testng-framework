package com.itihas.utils;

import io.restassured.response.Response;

public class ResponseValidator {
    public static void validateStatusCode(Response response, int expectedStatusCode, String errorMessage){
        if(response.getStatusCode() != expectedStatusCode){
            throw new RuntimeException(
                    errorMessage +
                            " | Expected: " + expectedStatusCode +
                            " | Actual: " + response.getStatusCode()
            );
        }
    }
}
