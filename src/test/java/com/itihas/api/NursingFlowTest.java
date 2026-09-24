package com.itihas.api;

import com.itihas.dto.NoInterviewTaskData;
import com.itihas.reporting.ExtentTestManager;
import org.testng.annotations.Test;

public class NursingFlowTest {

    @Test
    public void nursingApiService(){
        ExtentTestManager.getTest().info("Starting Nursing API Workflow");
        NursingApi nursingApi = new NursingApi();
        NoInterviewTaskData noInterviewData = nursingApi.getNoInterviewTask();


    }
}
