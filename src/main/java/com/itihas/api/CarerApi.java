package com.itihas.api;

import com.itihas.dto.CarerData;
import com.itihas.dto.CarerRequisitionData;
import com.itihas.dto.LeadData;
import com.itihas.dto.request.AddCarerRequest;
import com.itihas.reporting.ExtentTestManager;
import com.itihas.testdata.AddCarerDataBuilder;
import com.itihas.utils.LoggerUtil;
import com.itihas.utils.ResponseValidator;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;

public class CarerApi extends ApiBase{
    private static final Logger log = LoggerUtil.getLogger(CarerApi.class);
    private final ApiClient apiClient = new ApiClient();

    public CarerData addCarerRegionalCRT(){
        ExtentTestManager.getTest().info("Adding Carer Through Regional CRT");

        log.info("Adding Carer Through Regional CRT");

        AddCarerRequest request = AddCarerDataBuilder.build();
        Response response = apiClient.post("/admin/add-carer-regional-crt",request);

        ResponseValidator.validateStatusCode(response,200,"ADD CARER REGIONAL CRT FAILED");



        String carerUuid = response.jsonPath().getString("data.carer_details.user_uuid");
        String carerName = response.jsonPath().getString("data.carer_details.first_name");
        log.info("Carer Name: {}",carerName);
        log.info("Carer Uuid: {}",carerUuid);

        ExtentTestManager.getTest().pass("Carer Added Successfully");
        log.info("Carer Added Successfully");


        return new CarerData(carerUuid,carerName);


    }

    public CarerRequisitionData getCarerRequisitionTask() {

        String payload = """
        {
        "filters": {
            "tab": "pending"
        },
        "sort": {
            "field": "created_at",
            "order": "DESC"
        },
        "pagination": {
            "page": 1,
            "limit": 20
        },
        "query": ""
       }
       """;

        log.info("Fetching CRR Pending Tasks");

        Response response =
                apiClient.post(
                        "/admin/carer-requisition-request",
                        payload
                );

        ResponseValidator.validateStatusCode(
                response,
                200,
                "GET CRR TASK FAILED"
        );

        String requisitionUuid =
                response.jsonPath()
                        .getString("data[0].uuid");


        log.info(
                "Requisition UUID Found: {}",
                requisitionUuid
        );

        ExtentTestManager.getTest()
                .pass("CRR Task Found Successfully");

        return new CarerRequisitionData(requisitionUuid);
      }

}
