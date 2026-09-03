package com.itihas.api;

import com.itihas.utils.FakeDataGenerator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LeadFlowTest {

    private static final String TOKEN =
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MzYzNzM4LCJwYXNzd29yZF9sYXN0X3VwZGF0ZWRfYXQiOiIyMDI2LTAxLTA5IDE3OjQ1OjM5IiwiaWF0IjoxNzg4MzM5NDI3LCJleHAiOjE3OTA5MzE0Mjd9.-ywTjiZPheFewGXAVcv97iGnUVjkRVVw8aN1II7Ym88";


    @Test
    public void leadFlowTest() {

        String leadUuid = createLead();

        updateLeadAnswers(leadUuid);

        updateDisposition(leadUuid);

        System.out.println("Lead Flow Completed Successfully");
    }

    private String createLead() {

        String payload = String.format("""
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
                FakeDataGenerator.phoneNumber(),
                FakeDataGenerator.firstName(),
                FakeDataGenerator.lastName()
        );

        Response response =
                RestAssured
                        .given()
                        .header("Authorization", TOKEN)
                        .contentType("application/json")
                        .body(payload)
                        .when()
                        .post("https://api.emoha.com/api/v1/crm/add-temp-activity");

        validateResponse(response, "Create Lead");

        String leadUuid =
                response.jsonPath()
                        .getString("data[0].uuid");

        String elderUuid =
                response.jsonPath()
                        .getString("data[0].elder_uuid");

        System.out.println("Lead UUID : " + leadUuid);
        System.out.println("Elder UUID : " + elderUuid);

        return leadUuid;
    }

    private void updateLeadAnswers(String leadUuid) {

        String payload = String.format("""
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

        Response response =
                RestAssured
                        .given()
                        .header("Authorization", TOKEN)
                        .contentType("application/json")
                        .body(payload)
                        .when()
                        .put("https://api.emoha.com/api/v1/crm/update-lead-answers?check_permission=false");

        validateResponse(response, "Update Lead Answers");

        response.prettyPrint();
    }

    private void updateDisposition(String leadUuid) {

        String payload = String.format("""
                {
                    "lead_uuid": "%s",
                    "disposition_uuid": "b78948e8-07ed-11f1-80bc-0a74388da8eb",
                    "remark_uuid": null,
                    "follow_up_date_time": "2026-08-05T16:08:20.265Z"
                }
                """,
                leadUuid
        );

        Response response =
                RestAssured
                        .given()
                        .header("Authorization", TOKEN)
                        .contentType("application/json")
                        .body(payload)
                        .when()
                        .put("https://api.emoha.com/api/v1/crm/update-lead-disposition-remark?check_permission=false");

        validateResponse(response, "Update Disposition");

        response.prettyPrint();
    }

    private void validateResponse(Response response, String apiName) {

        if (response.getStatusCode() != 200) {

            throw new RuntimeException(
                    apiName + " API Failed. Status Code: "
                            + response.getStatusCode()
            );
        }

        System.out.println(
                apiName + " API Passed"
        );
    }
}