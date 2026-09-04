package com.itihas.api;

import com.itihas.utils.FakeDataGenerator;

import com.itihas.utils.ResponseValidator;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import javax.sound.midi.Soundbank;


public class LeadApi extends ApiBase{
    private final ApiClient apiClient = new ApiClient();
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

//        Response createLeadResponse =
//                RestAssured
//                        .given()
//                        .spec(REQUEST_SPEC)
//                        .body(createLeadPayload)
//                        .when()
//                        .post("/add-temp-activity");

        Response createLeadResponse = apiClient.post("/add-temp-activity",createLeadPayload);
        System.out.println("===== CREATE LEAD RESPONSE =====");
        createLeadResponse.prettyPrint();

//        if(createLeadResponse .getStatusCode()!=200){
//            throw new RuntimeException("Create Lead Failed");
//        }
        ResponseValidator.validateStatusCode(
                createLeadResponse,
                200,
                "Create Lead Failed"
        );



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

//        Response updateLeadResponse =
//                RestAssured
//                        .given()
//                        .spec(REQUEST_SPEC)
//                        .body(updateLeadPayload)
//                        .when()
//                        .put("/update-lead-answers?check_permission=false");

        Response updateLeadResponse = apiClient.put("/update-lead-answers?check_permission=false",updateLeadPayload);

        System.out.println("===== UPDATE LEAD RESPONSE =====");
        updateLeadResponse.prettyPrint();

//        if(updateLeadResponse.getStatusCode()!=200){
//            throw new RuntimeException("UPDATE LEAD ANSWER FAILED");
//        }
        ResponseValidator.validateStatusCode(updateLeadResponse,200,"UPDATE LEAD ANSWER FAILED");


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

//        Response updateLeadDispositionResponse =
//                RestAssured
//                        .given()
//                        .spec(REQUEST_SPEC)
//                        .body(updateLeadDispositionPayload)
//                        .when()
//                        .put("/update-lead-disposition-remark?check_permission=false");
        Response updateLeadDispositionResponse = apiClient.put("/update-lead-disposition-remark?check_permission=false",updateLeadDispositionPayload);

        System.out.println("===== UPDATE LEAD DISPOSITION RESPONSE =====");
        updateLeadDispositionResponse.prettyPrint();

//        if(updateLeadDispositionResponse.getStatusCode()!=200){
//            throw new RuntimeException("UPDATE LEAD DISPOSITION FAILED");
//        }

        ResponseValidator.validateStatusCode(updateLeadDispositionResponse,200,"UPDATE LEAD DISPOSITION FAILED");

    }


}
