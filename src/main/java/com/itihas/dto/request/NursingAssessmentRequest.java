package com.itihas.dto.request;

import java.util.Map;

public class NursingAssessmentRequest {

    private String lead_uuid;
    private Integer record_id;
    private String stage_name;
    private String status;
    private Map<String, String> values;

    // constructor
    public NursingAssessmentRequest(
            String lead_uuid,
            Integer record_id,
            String stage_name,
            String status,
            Map<String, String> values

    ){
        this.lead_uuid= lead_uuid;
        this.record_id=record_id;
        this.stage_name = stage_name;
        this.status = status;
        this.values=values;
    }

    // getters
    public String getLead_uuid(){
        return lead_uuid;
    }

    public Integer getRecord_id() {
        return record_id;
    }
    public String getStage_name(){
        return stage_name;
    }
    public String getStatus(){
        return status;
    }
    public Map<String, String> getValues() {
        return values;
    }
}
