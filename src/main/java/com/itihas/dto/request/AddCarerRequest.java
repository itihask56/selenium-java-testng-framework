package com.itihas.dto.request;

import java.util.List;

public class AddCarerRequest {

    private String carer_name;
    private String carer_number;
    private String carer_type;
    private String category;
    private String gender;
    private String age;
    private String region;
    private String service_experience;
    private String special_skills;
    private String aadhaar_number;
    private String source;
    private String language_preference;

    private List<String> other_carer_preferred_city;

    private boolean is_pseudonumber;

    private String city;
    private String photo;
    private String aadhaar_card;
    private String pan_card;
    private String experience_document;

    public AddCarerRequest(
            String carer_name,
            String carer_number,
            String carer_type,
            String category,
            String gender,
            String age,
            String region,
            String service_experience,
            String special_skills,
            String aadhaar_number,
            String source,
            String language_preference,
            List<String> other_carer_preferred_city,
            boolean is_pseudonumber,
            String city,
            String photo,
            String aadhaar_card,
            String pan_card,
            String experience_document
    ) {
        this.carer_name = carer_name;
        this.carer_number = carer_number;
        this.carer_type = carer_type;
        this.category = category;
        this.gender = gender;
        this.age = age;
        this.region = region;
        this.service_experience = service_experience;
        this.special_skills = special_skills;
        this.aadhaar_number = aadhaar_number;
        this.source = source;
        this.language_preference = language_preference;
        this.other_carer_preferred_city = other_carer_preferred_city;
        this.is_pseudonumber = is_pseudonumber;
        this.city = city;
        this.photo = photo;
        this.aadhaar_card = aadhaar_card;
        this.pan_card = pan_card;
        this.experience_document = experience_document;
    }

    public String getCarer_name() {
        return carer_name;
    }

    public String getCarer_number() {
        return carer_number;
    }

    public String getCarer_type() {
        return carer_type;
    }

    public String getCategory() {
        return category;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getRegion() {
        return region;
    }

    public String getService_experience() {
        return service_experience;
    }

    public String getSpecial_skills() {
        return special_skills;
    }

    public String getAadhaar_number() {
        return aadhaar_number;
    }

    public String getSource() {
        return source;
    }

    public String getLanguage_preference() {
        return language_preference;
    }

    public List<String> getOther_carer_preferred_city() {
        return other_carer_preferred_city;
    }

    public boolean isIs_pseudonumber() {
        return is_pseudonumber;
    }

    public String getCity() {
        return city;
    }

    public String getPhoto() {
        return photo;
    }

    public String getAadhaar_card() {
        return aadhaar_card;
    }

    public String getPan_card() {
        return pan_card;
    }

    public String getExperience_document() {
        return experience_document;
    }
}