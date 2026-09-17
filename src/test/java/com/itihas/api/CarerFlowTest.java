package com.itihas.api;

import com.itihas.dto.CarerData;
import com.itihas.dto.CarerRequisitionData;
import com.itihas.dto.LeadData;
import com.itihas.reporting.ExtentTestManager;
import org.testng.annotations.Test;

public class CarerFlowTest {
    @Test
    public void carerApiService(){
        ExtentTestManager.getTest().info("Starting Carer API Workflow");
        CarerApi carerApi = new CarerApi();
        CarerData carerData = carerApi.addCarerRegionalCRT();
        CarerRequisitionData carerRequisitionData = carerApi.getCarerRequisitionTask();
        carerApi.pushCarerToCflow(carerData.getCarerUuid(),carerRequisitionData.getRequisitionUuid());




    }
}
