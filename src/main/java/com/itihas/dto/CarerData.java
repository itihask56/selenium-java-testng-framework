package com.itihas.dto;

public class CarerData {
    private final String carerUuid;
    private final String carerName;
    public CarerData(String carerUuid,String carerName){
        this.carerUuid = carerUuid;
        this.carerName = carerName;
    }

    public String getCarerUuid() {
        return carerUuid;
    }
}
