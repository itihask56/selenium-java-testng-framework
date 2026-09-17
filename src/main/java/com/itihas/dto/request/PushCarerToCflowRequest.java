package com.itihas.dto.request;

public class PushCarerToCflowRequest {
    private String requisition_uuid;
    private String carer_uuid;
    private String cost;
    private String source;

    public PushCarerToCflowRequest(
            String requisitionUuid,
            String carerUuid,
            String cost,
            String source
    ) {
        this.requisition_uuid = requisitionUuid;
        this.carer_uuid = carerUuid;
        this.cost = cost;
        this.source = source;
    }

    public String getRequisition_uuid() {
        return requisition_uuid;
    }

    public String getCarer_uuid() {
        return carer_uuid;
    }

    public String getCost() {
        return cost;
    }

    public String getSource() {
        return source;
    }
}
