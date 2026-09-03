package com.itihas.api;

import com.itihas.utils.FakeDataGenerator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateLeadTest {

    @Test
    public void createLead() {

//        String payload = """
//                {
//                    "meta_data": {
//                        "lead_source": "Others",
//                        "lead_source_category": "Others",
//                        "mobile_number": "4444028402",
//                        "country_code": "+91",
//                        "campaign_name": "Ensure_Manual_Others",
//                        "ad_set": "default",
//                        "first_name": "test henry",
//                        "last_name": "Hodkiewicz",
//                        "vertical_name": "Ensure",
//                        "agent_email_id": "namrata.patra@emoha.com"
//                    }
//                }
//                """;

        String firstName =
                FakeDataGenerator.firstName();

        String lastName =
                FakeDataGenerator.lastName();

        String phoneNumber =
                FakeDataGenerator.phoneNumber();
        String payload = String.format(
                """
                {
                    "meta_data": {
                        "lead_source": "Others",
                        "lead_source_category": "Others",
                        "mobile_number": "%s",
                        "country_code": "+91",
                        "campaign_name": "Ensure_Manual_Others",
                        "ad_set": "default",
                        "first_name": "%s",
                        "last_name": "%s",
                        "vertical_name": "Ensure",
                        "agent_email_id": "namrata.patra@emoha.com"
                    }
                }
                """,
                phoneNumber,
                firstName,
                lastName
        );

        Response response =
                RestAssured
                        .given()
                        .header("Authorization", "Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MzYzNzM4LCJwYXNzd29yZF9sYXN0X3VwZGF0ZWRfYXQiOiIyMDI2LTAxLTA5IDE3OjQ1OjM5IiwiaWF0IjoxNzg4MzM5NDI3LCJleHAiOjE3OTA5MzE0Mjd9.-ywTjiZPheFewGXAVcv97iGnUVjkRVVw8aN1II7Ym88")
                        .contentType("application/json")
                        .body(payload)
                        .when()
                        .post("https://api.emoha.com/api/v1/crm/add-temp-activity");

        response.prettyPrint();

        String leadUuid =
                response.jsonPath()
                        .getString("data[0].uuid");

        String elderUuid =
                response.jsonPath()
                        .getString("data[0].elder_uuid");

        System.out.println("Lead UUID : " + leadUuid);
        System.out.println("Elder UUID : " + elderUuid);
        System.out.println("Elder Name : "+ firstName+" "+lastName);
    }
}