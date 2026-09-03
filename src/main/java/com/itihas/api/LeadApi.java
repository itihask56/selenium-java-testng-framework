package com.itihas.api;

import com.itihas.utils.FakeDataGenerator;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class LeadApi {
    private static final String TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MzYzNzM4LCJwYXNzd29yZF9sYXN0X3VwZGF0ZWRfYXQiOiIyMDI2LTAxLTA5IDE3OjQ1OjM5IiwiaWF0IjoxNzg4MzM5NDI3LCJleHAiOjE3OTA5MzE0Mjd9.-ywTjiZPheFewGXAVcv97iGnUVjkRVVw8aN1II7Ym88";
    private static final String BASE_URL = "https://api.emoha.com/api/v1/crm";

    public String createLead(){
        String firstName = FakeDataGenerator.firstName();

        String lastName = FakeDataGenerator.lastName();

        String phoneNumber = FakeDataGenerator.phoneNumber();
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
                        .post(BASE_URL+"/add-temp-activity");

        if(createLeadResponse .getStatusCode()!=200){
            throw new RuntimeException("Create Lead Failed");
        }

        System.out.println("===== CREATE LEAD RESPONSE =====");
        createLeadResponse.prettyPrint();

        String leadUuid = createLeadResponse .jsonPath().getString("data[0].uuid");
        String elderUuid = createLeadResponse.jsonPath().getString("data[0].elder_uuid");
        System.out.println("LEAD_UUID: "+ leadUuid);
        System.out.println("ELDER_UUID: "+ elderUuid);
        return leadUuid;
    }


    public void updateLeadAnswer(String leadUuid){
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
                        .put(BASE_URL+"/update-lead-answers?check_permission=false");
        if(updateLeadResponse.getStatusCode()!=200){
            throw new RuntimeException("UPDATE LEAD ANSWER FAILED");
        }

        System.out.println("===== UPDATE LEAD RESPONSE =====");
        updateLeadResponse.prettyPrint();
    }

    public void updateLeadDisposition(String leadUuid){
        String updateLeadDispositionPayload = String.format("""
                {
                    "lead_uuid": "%s",
                    "disposition_uuid": "b78948e8-07ed-11f1-80bc-0a74388da8eb",
                    "remark_uuid": null,
                    "follow_up_date_time": "2026-08-05T16:08:20.265Z"
                }
                """,
                leadUuid
        );

        Response updateLeadDispositionResponse =
                RestAssured
                        .given()
                        .header("Authorization", TOKEN)
                        .contentType("application/json")
                        .body(updateLeadDispositionPayload)
                        .when()
                        .put(BASE_URL+"/update-lead-disposition-remark?check_permission=false");

        if(updateLeadDispositionResponse.getStatusCode()!=200){
            throw new RuntimeException("UPDATE LEAD DISPOSITION FAILED");
        }
        System.out.println("===== UPDATE LEAD DISPOSITION RESPONSE =====");
        updateLeadDispositionResponse.prettyPrint();
    }


}
