package com.itihas.dto.request;

public class UpdateLeadDispositionRequest {
    private String lead_uuid;
    private String disposition_uuid;
    private String remark_uuid;
    private String follow_up_date_time;

    public  UpdateLeadDispositionRequest(
            String lead_uuid,
            String disposition_uuid,
            String remark_uuid,
            String follow_up_date_time
    ){
        this.lead_uuid= lead_uuid;
        this.disposition_uuid = disposition_uuid;
        this.remark_uuid = remark_uuid;
        this.follow_up_date_time = follow_up_date_time;
    }

    public String getDisposition_uuid() {
        return disposition_uuid;
    }

    public String getLead_uuid() {
        return lead_uuid;
    }

    public String getFollow_up_date_time() {
        return follow_up_date_time;
    }

    public String getRemark_uuid() {
        return remark_uuid;
    }
}
