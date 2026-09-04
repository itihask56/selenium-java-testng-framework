package com.itihas.api;

import com.itihas.reporting.ExtentTestManager;
import org.testng.annotations.Test;

public class LeadFlowTest {

    @Test
    public void leadApiService(){
        ExtentTestManager.getTest().info("Starting Lead API Workflow");

        LeadApi leadApi = new LeadApi();
        String leadUuid = leadApi.createLead();
        leadApi.updateLeadAnswer(leadUuid);
        leadApi.updateLeadDisposition(leadUuid);

    }
}
