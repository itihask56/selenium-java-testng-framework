package com.itihas.filter;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;

import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ApiLoggingFilter implements Filter {

    private static final Logger log =
            LogManager.getLogger(ApiLoggingFilter.class);

    private static final ObjectMapper objectMapper =
            new ObjectMapper()
                    .enable(SerializationFeature.INDENT_OUTPUT);

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

            try {

                String prettyJson = objectMapper
                        .readTree(requestSpec.getBody().toString())
                        .toPrettyString();

                log.info("Request Body:\n{}", prettyJson);

            } catch (Exception e) {

                log.info(
                        "Request Body:\n{}",
                        requestSpec.getBody().toString()
                );
            }
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