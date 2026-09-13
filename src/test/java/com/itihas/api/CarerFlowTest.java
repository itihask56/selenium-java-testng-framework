package com.itihas.api;

import com.itihas.dto.CarerData;
import com.itihas.reporting.ExtentTestManager;
import org.testng.annotations.Test;

public class CarerFlowTest {
    @Test
    public void carerApiService(){
        ExtentTestManager.getTest().info("Starting Carer API Workflow");
         CarerApi carerApi = new CarerApi();
         CarerData carerData = carerApi.addCarerRegionalCRT();


    }
}
