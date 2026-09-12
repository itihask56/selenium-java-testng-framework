package com.itihas.dto.request;

import java.util.Map;

public class LeadScreeningRequest {
    private String stage_name;
    private String record_id;
    private String status;
    private Map<String, String> values;
    private String lead_uuid;
    public LeadScreeningRequest(
            String stage_name,
            String record_id,
            String status,
            Map<String, String> values,
            String lead_uuid
    ){
        this.stage_name = stage_name;
        this.record_id = record_id;
        this.status = status;
        this.values = values;
        this.lead_uuid = lead_uuid;
    }

    public String getStage_name() {
        return stage_name;
    }

    public String getRecord_id() {
        return record_id;
    }

    public String getStatus() {
        return status;
    }

    public Map<String, String> getValues() {
        return values;
    }

    public String getLead_uuid() {
        return lead_uuid;
    }
}
