package com.itihas.api;

import org.testng.annotations.Test;

public class LeadFlowTest {

    @Test
    public void leadApiService(){

        LeadApi leadApi = new LeadApi();
        String leadUuid = leadApi.createLead();
        leadApi.updateLeadAnswer(leadUuid);
        leadApi.updateLeadDisposition(leadUuid);

    }
}
