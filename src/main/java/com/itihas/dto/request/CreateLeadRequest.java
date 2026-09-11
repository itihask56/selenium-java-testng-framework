package com.itihas.dto.request;

public class CreateLeadRequest {
    private MetaData meta_data;
    public CreateLeadRequest(MetaData meta_data){
        this.meta_data=meta_data;
    }
    public MetaData getMeta_data(){
        return meta_data;
    }
}
