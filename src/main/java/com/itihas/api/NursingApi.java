package com.itihas.api;

import com.itihas.auth.UserRole;
import com.itihas.dto.NoInterviewTaskData;
import com.itihas.dto.request.NoInterviewRequest;
import com.itihas.reporting.ExtentTestManager;
import com.itihas.testdata.NoInterviewDataBuilder;
import com.itihas.utils.LoggerUtil;
import com.itihas.utils.ResponseValidator;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;

public class NursingApi extends ApiBase {
    private static final Logger log = LoggerUtil.getLogger(NursingApi.class);
    private final ApiClient apiClient = new ApiClient(UserRole.SNO);

    public NoInterviewTaskData getNoInterviewTask() {

        log.info("Fetching NO Interview Task");

        Response response =
                apiClient.get(
                        "/admin/nh/my-tasks/list"
                                + "?task_type=noInterview"
                                + "&search="
                                + "&sort_order=DESC"
                                + "&page=1"
                                + "&page_size=10"
                );

        ResponseValidator.validateStatusCode(
                response,
                200,
                "NO INTERVIEW TASK FETCH FAILED"
        );

        String elderName = response.jsonPath().getString("data.tasks[0].elderName");
        String subprocessRecordId = response.jsonPath().getString("data.tasks[0].recordId");
        String taskUuid = response.jsonPath().getString("data.tasks[0].taskUuid");

        log.info("Elder Name: {}",elderName);
        log.info("Subprocess Record Id: {}",subprocessRecordId);
        log.info("NO Interview Task UUID: {}", taskUuid);


        return new NoInterviewTaskData(elderName,subprocessRecordId,taskUuid);
    }

    public void completeNoInterviewTask(String taskUuid){

        ExtentTestManager.getTest()
                .info("Starting NO Interview Task Completion");

        log.info("Starting NO Interview Task Completion");

        NoInterviewRequest request =
                NoInterviewDataBuilder.build(taskUuid);

        Response response =
                apiClient.post(
                        "/admin/nh/task-form/submission",
                        request
                );

        ResponseValidator.validateStatusCode(
                response,
                200,
                "NO INTERVIEW FAILED"
        );

        log.info(
                "NO Interview Completed Successfully |  Task UUID: {}",
                taskUuid


        );

        ExtentTestManager.getTest()
                .pass(
                        "NO Interview Completed Successfully"
                );
    }


}
