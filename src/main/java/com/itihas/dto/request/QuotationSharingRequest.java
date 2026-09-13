package com.itihas.dto.request;

import java.util.Map;

public class QuotationSharingRequest {
    private String stage_name;
    private Integer record_id;
    private String status;
    private String lead_uuid;
    private String service_start_date;
    private Map<String ,String> values;

    public QuotationSharingRequest(
            String stage_name,
            Integer record_id,
            String status,
            String lead_uuid,
            String service_start_date,
            Map<String,String> values
    ){
        this.stage_name = stage_name;
        this.record_id = record_id;
        this.status = status;
        this.lead_uuid = lead_uuid;
        this.service_start_date = service_start_date;
        this.values = values;
    }

    public String getStage_name() {
        return stage_name;
    }

    public Integer getRecord_id() {
        return record_id;
    }

    public String getStatus() {
        return status;
    }

    public String getLead_uuid() {
        return lead_uuid;
    }

    public String getService_start_date() {
        return service_start_date;
    }

    public Map<String, String> getValues() {
        return values;
    }
}
