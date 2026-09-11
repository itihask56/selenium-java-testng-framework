package com.itihas.filter;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;

import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApiLoggingFilter implements Filter {

    private static final Logger log =
            LogManager.getLogger(ApiLoggingFilter.class);

    @Override
    public Response filter(
            FilterableRequestSpecification requestSpec,
            FilterableResponseSpecification responseSpec,
            FilterContext ctx
    ) {

        log.info("========== API REQUEST ==========");
        log.info(
                "{} {}",
                requestSpec.getMethod(),
                requestSpec.getURI()
        );

        if (requestSpec.getBody() != null) {
            log.info("Request Body:\n{}","",requestSpec.getBody());
        }

        Response response =
                ctx.next(requestSpec, responseSpec);

        log.info("========== API RESPONSE ==========");
        log.info(
                "Status Code: {}",
                response.getStatusCode()
        );

        log.info(
                "Response Body:\n{}",
                response.getBody().asPrettyString()
        );

        return response;
    }
}