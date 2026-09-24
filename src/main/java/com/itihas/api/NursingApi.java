package com.itihas.api;

import com.itihas.auth.UserRole;
import com.itihas.dto.NoInterviewTaskData;
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



}
