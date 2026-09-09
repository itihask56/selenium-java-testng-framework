package com.itihas.utils;

import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;

public class ResponseValidator {
    private static final Logger log = LoggerUtil.getLogger(ResponseValidator.class);
    public static void validateStatusCode(Response response, int expectedStatusCode, String errorMessage){
        if(response.getStatusCode() != expectedStatusCode){
            log.error(
                    "{} | Expected: {} | Actual: {}",
                    errorMessage,
                    expectedStatusCode,
                    response.getStatusCode()
            );
            throw new RuntimeException(
                    errorMessage
                            + " | Expected: "
                            + expectedStatusCode
                            + " | Actual: "
                            + response.getStatusCode()
            );
        }
    }
}
