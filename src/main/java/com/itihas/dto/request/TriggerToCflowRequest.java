package com.itihas.dto.request;

public class TriggerToCflowRequest {
    private String lead_uuid;
    private String principal_sale;
    private String elder_uuid;
    private boolean new_flow;

    public  TriggerToCflowRequest(
            String lead_uuid,
            String principal_sale,
            String elder_uuid,
            boolean new_flow
    ){
        this.lead_uuid=lead_uuid;
        this.principal_sale=principal_sale;
        this.elder_uuid=elder_uuid;
        this.new_flow = new_flow;
    }

    public String getLead_uuid(){
        return lead_uuid;
    }

    public String getPrincipal_sale(){
        return principal_sale;
    }

    public String getElder_uuid() {
        return elder_uuid;
    }

    public boolean isNew_flow() {
        return new_flow;
    }
}
