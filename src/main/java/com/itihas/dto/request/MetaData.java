package com.itihas.dto.request;

public class MetaData {

    private String lead_source;
    private String lead_source_category;
    private String mobile_number;
    private String country_code;
    private String campaign_name;
    private String ad_set;
    private String first_name;
    private String last_name;
    private String vertical_name;
    private String agent_email_id;

    public MetaData(
            String lead_source,
            String lead_source_category,
            String mobile_number,
            String country_code,
            String campaign_name,
            String ad_set,
            String first_name,
            String last_name,
            String vertical_name,
            String agent_email_id
    ) {
        this.lead_source = lead_source;
        this.lead_source_category = lead_source_category;
        this.mobile_number = mobile_number;
        this.country_code = country_code;
        this.campaign_name = campaign_name;
        this.ad_set = ad_set;
        this.first_name = first_name;
        this.last_name = last_name;
        this.vertical_name = vertical_name;
        this.agent_email_id = agent_email_id;
    }

    public String getLead_source() {
        return lead_source;
    }

    public String getLead_source_category() {
        return lead_source_category;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getCampaign_name() {
        return campaign_name;
    }

    public String getAd_set() {
        return ad_set;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getVertical_name() {
        return vertical_name;
    }

    public String getAgent_email_id() {
        return agent_email_id;
    }
}