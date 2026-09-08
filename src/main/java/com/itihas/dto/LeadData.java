package com.itihas.dto;

public class LeadData {
    private final String leadUuid;
    private final String elderUuid;

    public LeadData(String leadUuid,String elderUuid){
        this.leadUuid = leadUuid;
        this.elderUuid = elderUuid;

    }

    public String getLeadUuid(){
        return leadUuid;
    }
    public String getElderUuid(){
        return elderUuid;
    }


}
