package com.itihas.api;

import com.itihas.utils.FakeDataGenerator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UpdateLeadAnswer {

    private static final String TOKEN =
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MzYzNzM4LCJwYXNzd29yZF9sYXN0X3VwZGF0ZWRfYXQiOiIyMDI2LTAxLTA5IDE3OjQ1OjM5IiwiaWF0IjoxNzg4MzM5NDI3LCJleHAiOjE3OTA5MzE0Mjd9.-ywTjiZPheFewGXAVcv97iGnUVjkRVVw8aN1II7Ym88";

    @Test
    public void leadFlowTest() {

        // ==========================
        // Generate Dynamic Test Data
        // ==========================

        String firstName = FakeDataGenerator.firstName();
        String lastName = FakeDataGenerator.lastName();
        String phoneNumber = FakeDataGenerator.phoneNumber();

        // ==========================
        // API 1 - Create Lead
        // ==========================

        String createLeadPayload = String.format(
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

        Response createLeadResponse =
                RestAssured
                        .given()
                        .header("Authorization", TOKEN)
                        .contentType("application/json")
                        .body(createLeadPayload)
                        .when()
                        .post("https://api.emoha.com/api/v1/crm/add-temp-activity");

        createLeadResponse.prettyPrint();



        if(createLeadResponse.getStatusCode() != 200){

            throw new RuntimeException(
                    "Create Lead API Failed"
            );
        }

        String leadUuid = createLeadResponse.jsonPath().getString("data[0].uuid");




        String elderUuid =
                createLeadResponse
                        .jsonPath()
                        .getString("data[0].elder_uuid");

        System.out.println("Lead UUID : " + leadUuid);
        System.out.println("Elder UUID : " + elderUuid);

        // ==========================
        // API 2 - Update Lead Answers
        // ==========================

        String updateLeadPayload = String.format("""
                {
                    "lead_uuid": "%s",
                    "answers": {
                        "Region": "West",
                        "Services requirements": "Carer",
                        "Carer Type": "Nurse",
                        "Service City": "Mumbai"
                    }
                }
                """,
                leadUuid
        );

        Response updateLeadResponse =
                RestAssured
                        .given()
                        .header("Authorization", TOKEN)
                        .contentType("application/json")
                        .body(updateLeadPayload)
                        .when()
                        .put("https://api.emoha.com/api/v1/crm/update-lead-answers?check_permission=false");
        if(updateLeadResponse.getStatusCode()!=200){
            throw new RuntimeException("UPDATE LEAD ANSWER FAILED");
        }

        System.out.println("===== UPDATE LEAD RESPONSE =====");
        updateLeadResponse.prettyPrint();
    }
}