package com.itihas.dto.request;

import java.util.Map;

public class UpdateLeadAnswerRequest {

    private String lead_uuid;
    private Map<String, String> answers;

    public UpdateLeadAnswerRequest(
            String lead_uuid,
            Map<String, String> answers
    ) {
        this.lead_uuid = lead_uuid;
        this.answers = answers;
    }

    public String getLead_uuid() {
        return lead_uuid;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }
}