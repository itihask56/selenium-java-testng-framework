package com.itihas.api;

import com.itihas.dto.request.*;
import com.itihas.utils.FakeDataGenerator;

import com.itihas.utils.LoggerUtil;
import com.itihas.utils.ResponseValidator;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import com.itihas.reporting.ExtentTestManager;
import com.itihas.dto.LeadData;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class LeadApi extends ApiBase{
    private static final Logger log = LoggerUtil.getLogger(LeadApi.class);


    private final ApiClient apiClient = new ApiClient();
    public LeadData createLead(){
        String firstName = FakeDataGenerator.firstName();

        String lastName = FakeDataGenerator.lastName();

        String phoneNumber = FakeDataGenerator.phoneNumber();
        log.info(
                "Creating lead for {} {} | Mobile: {}",
                firstName,
                lastName,
                phoneNumber
        );
//        String createLeadPayload = String.format(
//                """
//                {
//                    "meta_data": {
//                        "lead_source": "Others",
//                        "lead_source_category": "Others",
//                        "mobile_number": "%s",
//                        "country_code": "+91",
//                        "campaign_name": "Ensure_Manual_Others",
//                        "ad_set": "default",
//                        "first_name": "%s",
//                        "last_name": "%s",
//                        "vertical_name": "Ensure",
//                        "agent_email_id": "namrata.patra@emoha.com"
//                    }
//                }
//                """,
//                phoneNumber,
//                firstName,
//                lastName
//        );

        MetaData meta_data = new MetaData(
                "Others",
                "Others",
                phoneNumber,
                "+91",
                "Ensure_Manual_Others",
                "default",
                firstName,
                lastName,
                "Ensure",
                "namrata.patra@emoha.com"


        );

        CreateLeadRequest request = new CreateLeadRequest(meta_data);

//        Response createLeadResponse =
//                RestAssured
//                        .given()
//                        .spec(REQUEST_SPEC)
//                        .body(createLeadPayload)
//                        .when()
//                        .post("/add-temp-activity");

        ExtentTestManager.getTest().info("Creating Lead");
        log.info("Sending Create Lead API request");
        Response createLeadResponse = apiClient.post("/add-temp-activity",request);
        log.info("Create Lead Response Status Code: {}", createLeadResponse.getStatusCode());

        log.debug("Create Lead Response Body: {}", createLeadResponse.asPrettyString());
//        createLeadResponse.prettyPrint();

//        if(createLeadResponse .getStatusCode()!=200){
//            throw new RuntimeException("Create Lead Failed");
//        }
        ResponseValidator.validateStatusCode(
                createLeadResponse,
                200,
                "Create Lead Failed"
        );

        ExtentTestManager.getTest().pass("Lead Created Successfully");


        String leadUuid = createLeadResponse .jsonPath().getString("data[0].uuid");
        String elderUuid = createLeadResponse.jsonPath().getString("data[0].elder_uuid");
        log.info("Lead Created Successfully");
        log.info("Lead UUID: {}", leadUuid);
        log.info("Elder UUID: {}", elderUuid);
        return new LeadData(leadUuid,elderUuid);
    }


    public void updateLeadAnswer(String leadUuid){
        Map<String, String> answers = new HashMap<>();

        answers.put("Region", "West");
        answers.put("Services requirements", "Carer");
        answers.put("Carer Type", "Nurse");
        answers.put("Service City", "Mumbai");

        UpdateLeadAnswerRequest request =
                new UpdateLeadAnswerRequest(
                        leadUuid,
                        answers
                );
        log.info("Updating lead answers | Lead UUID: {}", leadUuid);
//        String updateLeadPayload = String.format("""
//                {
//                    "lead_uuid": "%s",
//                    "answers": {
//                        "Region": "West",
//                        "Services requirements": "Carer",
//                        "Carer Type": "Nurse",
//                        "Service City": "Mumbai"
//                    }
//                }
//                """,
//                leadUuid
//        );

//        Response updateLeadResponse =
//                RestAssured
//                        .given()
//                        .spec(REQUEST_SPEC)
//                        .body(updateLeadPayload)
//                        .when()
//                        .put("/update-lead-answers?check_permission=false");

        ExtentTestManager.getTest().info("Updating Lead Answers");

        Response updateLeadResponse = apiClient.put("/update-lead-answers?check_permission=false",request);
//
//        System.out.println("===== UPDATE LEAD RESPONSE =====");
//        updateLeadResponse.prettyPrint();

//        if(updateLeadResponse.getStatusCode()!=200){
//            throw new RuntimeException("UPDATE LEAD ANSWER FAILED");
//        }
        ResponseValidator.validateStatusCode(updateLeadResponse,200,"UPDATE LEAD ANSWER FAILED");
        ExtentTestManager.getTest().pass("Lead Answers Updated Successfully");
        log.info("Lead answers updated successfully");


    }

    public void updateLeadDisposition(String leadUuid){
        log.info("Updating lead disposition | Lead UUID: {}", leadUuid);
//        String updateLeadDispositionPayload = String.format("""
//                {
//                    "lead_uuid": "%s",
//                    "disposition_uuid": "b78948e8-07ed-11f1-80bc-0a74388da8eb",
//                    "remark_uuid": null,
//                    "follow_up_date_time": "2026-08-05T16:08:20.265Z"
//                }
//                """,
//                leadUuid
//        );

        UpdateLeadDispositionRequest request = new UpdateLeadDispositionRequest(
                leadUuid,
                "b78948e8-07ed-11f1-80bc-0a74388da8eb",
                null,
                "2026-08-05T16:08:20.265Z"
        );

//        Response updateLeadDispositionResponse =
//                RestAssured
//                        .given()
//                        .spec(REQUEST_SPEC)
//                        .body(updateLeadDispositionPayload)
//                        .when()
//                        .put("/update-lead-disposition-remark?check_permission=false");
        ExtentTestManager.getTest().info("Updating Lead Disposition");
        Response updateLeadDispositionResponse = apiClient.put("/update-lead-disposition-remark?check_permission=false",request);

//        System.out.println("===== UPDATE LEAD DISPOSITION RESPONSE =====");
//        updateLeadDispositionResponse.prettyPrint();

//        if(updateLeadDispositionResponse.getStatusCode()!=200){
//            throw new RuntimeException("UPDATE LEAD DISPOSITION FAILED");
//        }

        ResponseValidator.validateStatusCode(updateLeadDispositionResponse,200,"UPDATE LEAD DISPOSITION FAILED");
        ExtentTestManager.getTest().pass("Lead Disposition Updated Successfully");
        log.info("Lead disposition updated successfully");

    }

    public void triggerToCflow(String leadUuid,String elderUuid){
//        String triggerToCflowPayload = String.format(
//                """
//                 {
//                 "lead_uuid":"%s",
//                 "principal_sale": "Elder",
//                 "elder_uuid": "%s",
//                 "new_flow": true
//                 }
//                """,
//                leadUuid,
//                elderUuid
//        );

        TriggerToCflowRequest request =
                new TriggerToCflowRequest(
                        leadUuid,
                        "Elder",
                        elderUuid,
                        true

                );

        ExtentTestManager.getTest().info("Triggering Lead To CFlow");
        log.info(
                "Triggering lead to CFlow | Lead UUID: {} | Elder UUID: {}",
                leadUuid,
                elderUuid
        );

        Response triggerToCflowResponse = apiClient.post("/trigger-to-cflow",request);
//        System.out.println(
//                "===== TRIGGER TO CFLOW RESPONSE ====="
//        );
 //       triggerToCflowResponse.prettyPrint();

        ResponseValidator.validateStatusCode(
                triggerToCflowResponse,
                200,
                "TRIGGER TO CFLOW FAILED"
        );
        ExtentTestManager.getTest()
                .pass("Lead Triggered To CFlow Successfully");
        log.info("Lead triggered to CFlow successfully");
    }


}
