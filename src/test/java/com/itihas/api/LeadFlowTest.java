package com.itihas.api;

import com.itihas.dto.LeadData;
import com.itihas.reporting.ExtentTestManager;
import org.testng.annotations.Test;

public class LeadFlowTest {

    @Test
    public void leadApiService(){
        ExtentTestManager.getTest().info("Starting Lead API Workflow");

        try{
            LeadApi leadApi = new LeadApi();
            LeadData leadData = leadApi.createLead();
            leadApi.updateLeadAnswer(leadData.getLeadUuid());
            leadApi.updateLeadDisposition(leadData.getLeadUuid());
            leadApi.triggerToCflow(leadData.getLeadUuid(),leadData.getElderUuid());

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }



    }
}
