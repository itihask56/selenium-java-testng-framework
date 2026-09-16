package com.itihas.dto;

public class CarerData {
    private final String carerUuid;
    public CarerData(String carerUuid,String carerName){
        this.carerUuid = carerUuid;
    }

    public String getCarerUuid() {
        return carerUuid;
    }
}
