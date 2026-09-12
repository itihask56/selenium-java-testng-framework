package com.itihas.api;

import com.itihas.dto.LeadScreeningData;
import com.itihas.dto.request.*;
import com.itihas.testdata.NursingAssessmentDataBuilder;
import com.itihas.utils.FakeDataGenerator;

import com.itihas.utils.LoggerUtil;
import com.itihas.utils.ResponseValidator;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import com.itihas.reporting.ExtentTestManager;
import com.itihas.dto.LeadData;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
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
        Response createLeadResponse = apiClient.post("/crm/add-temp-activity",request);
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

        ExtentTestManager.getTest().info("Updating Lead Answers");

        Response updateLeadResponse = apiClient.put("/crm/update-lead-answers?check_permission=false",request);

        ResponseValidator.validateStatusCode(updateLeadResponse,200,"UPDATE LEAD ANSWER FAILED");
        ExtentTestManager.getTest().pass("Lead Answers Updated Successfully");
        log.info("Lead answers updated successfully");


    }

    public void updateLeadDisposition(String leadUuid){
        log.info("Updating lead disposition | Lead UUID: {}", leadUuid);
        UpdateLeadDispositionRequest request = new UpdateLeadDispositionRequest(
                leadUuid,
                "b78948e8-07ed-11f1-80bc-0a74388da8eb",
                null,
                "2026-08-05T16:08:20.265Z"
        );


        ExtentTestManager.getTest().info("Updating Lead Disposition");
        Response updateLeadDispositionResponse = apiClient.put("/crm/update-lead-disposition-remark?check_permission=false",request);

        ResponseValidator.validateStatusCode(updateLeadDispositionResponse,200,"UPDATE LEAD DISPOSITION FAILED");
        ExtentTestManager.getTest().pass("Lead Disposition Updated Successfully");
        log.info("Lead disposition updated successfully");

    }

    public void triggerToCflow(String leadUuid,String elderUuid){


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

        Response triggerToCflowResponse = apiClient.post("/crm/trigger-to-cflow",request);
        ResponseValidator.validateStatusCode(
                triggerToCflowResponse,
                200,
                "TRIGGER TO CFLOW FAILED"
        );
        ExtentTestManager.getTest()
                .pass("Lead Triggered To CFlow Successfully");
        log.info("Lead triggered to CFlow successfully");
    }

    public LeadScreeningData getLeadScreeningData(String leadUuid) {

        log.info(
                "Fetching Lead Screening Data for Lead UUID: {}",
                leadUuid
        );

        ExtentTestManager.getTest()
                .info("Fetching Lead Screening Record ID");
        ExtentTestManager.getTest()
                .info("Searching Record ID generated by CFlow");
        Response response =
                apiClient.get(
                        "/admin/cflow-crm/dashboard-task-list?stage=0"
                );

        ResponseValidator.validateStatusCode(
                response,
                200,
                "GET LEAD SCREENING DATA FAILED"
        );

        List<Map<String, Object>> records =
                response.jsonPath()
                        .getList("data");

        Integer recordId = null;

        for (Map<String, Object> record : records) {

            String responseLeadUuid =
                    (String) record.get("lead_uuid");

            if (leadUuid.equals(responseLeadUuid)) {

                recordId =
                        (Integer) record.get("record_id");

                break;
            }
        }

        if (recordId == null) {

            log.error(
                    "Record ID not found for Lead UUID: {}",
                    leadUuid
            );

            throw new RuntimeException(
                    "Record ID not found for Lead UUID: "
                            + leadUuid
            );
        }

        log.info(
                "Record ID Found: {}",
                recordId
        );

        ExtentTestManager.getTest()
                .pass(
                        "Record ID Found Successfully : "
                                + recordId
                );

        return new LeadScreeningData(recordId);
    }

    public void completeLeadScreening(String leadUuid, Integer recordId) {

        log.info("Completing Lead Screening | Lead UUID: {} | Record ID: {}", leadUuid, recordId);

        ExtentTestManager.getTest().info("Completing Lead Screening");

        Map<String, String> values = new HashMap<>();

        values.put("Service Required", "Carer");
        values.put("Staff Required", "1");
        values.put("Service Start Date", "08-08-2026");
        values.put("For how long do you need our services?", "Days");
        values.put("Number Of Days", "5");
        values.put("Nursing Assessment Type", "Virtual Nursing Assessment");
        values.put("Assign to Central NO", "namrata.patra@emoha.com");


        LeadScreeningRequest request = new LeadScreeningRequest(
                "Lead Screening",
                String.valueOf(recordId),
                "Qualified",
                values,
                leadUuid
        );
        Response response = apiClient.post("/admin/cflow-crm/update-stage-details-in-workflow", request);

        ResponseValidator.validateStatusCode(
                response,
                200,
                "LEAD SCREENING FAILED"
        );

        log.info("Lead Screening Completed Successfully");

        ExtentTestManager.getTest().pass("Lead Screening Completed Successfully");
    }


    public void completeNursingAssessment(String leadUuid, Integer recordId) {

        log.info(
                "Completing Nursing Assessment | Lead UUID: {} | Record ID: {}",
                leadUuid,
                recordId
        );

        ExtentTestManager.getTest()
                .info("Completing Nursing Assessment");

        Map<String, String> values = NursingAssessmentDataBuilder.build();

        NursingAssessmentRequest request =
                new NursingAssessmentRequest(
                        leadUuid,
                        Integer.valueOf(recordId),
                        "Nursing Assessment",
                        "Completed",
                        values
                );

        Response response =
                apiClient.post(
                        "/admin/cflow-crm/update-stage-details-in-workflow",
                        request
                );

        ResponseValidator.validateStatusCode(
                response,
                200,
                "NURSING ASSESSMENT FAILED"
        );

        ExtentTestManager.getTest()
                .pass(
                        "Nursing Assessment Completed Successfully"
                );

        log.info(
                "Nursing Assessment Completed Successfully"
        );

    }

}
