package com.itihas.dto;

public class CarerRequisitionData {
    private final String requisitionUuid;


    public CarerRequisitionData(String requisitionUuid){
        this.requisitionUuid = requisitionUuid;

    }
    public String getRequisitionUuid(){
        return requisitionUuid;
    }

}
