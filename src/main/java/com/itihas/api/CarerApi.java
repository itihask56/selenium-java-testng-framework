package com.itihas.api;

import com.itihas.auth.UserRole;
import com.itihas.dto.CarerData;
import com.itihas.dto.CarerRequisitionData;
import com.itihas.dto.request.AddCarerRequest;
import com.itihas.dto.request.PushCarerToCflowRequest;
import com.itihas.reporting.ExtentTestManager;
import com.itihas.testdata.AddCarerDataBuilder;
import com.itihas.utils.LoggerUtil;
import com.itihas.utils.ResponseValidator;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;

public class CarerApi extends ApiBase{
    private static final Logger log = LoggerUtil.getLogger(CarerApi.class);
    private final ApiClient apiClient = new ApiClient(UserRole.CRT);

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

      public void pushCarerToCflow(String carerUuid,String requisitionUuid){

          ExtentTestManager.getTest().info("Pushing Carer Profile to Cflow");

          log.info(
                  "Pushing Carer to Cflow | Requisition UUID: {} | Carer UUID: {}",
                  requisitionUuid,
                  carerUuid
          );

          PushCarerToCflowRequest request =
                  new PushCarerToCflowRequest(
                          requisitionUuid,
                          carerUuid,
                          "2",
                          "vendor"
                  );

          Response response =
                  apiClient.post(
                          "/admin/carer-requisition-pushed-to-cflow",
                          request
                  );

          log.info("Response Status: {}", response.getStatusCode());
          log.info(
                  "Response Body: {}",
                  response.getBody().asPrettyString()
          );


          ResponseValidator.validateStatusCode(response,200,"PUSH CARER TO CFLOW FAILED");

          log.info("Carer pushed to cflow successfully");
          ExtentTestManager.getTest().info("Carer Pushed to cflow successfully");



      }

}
