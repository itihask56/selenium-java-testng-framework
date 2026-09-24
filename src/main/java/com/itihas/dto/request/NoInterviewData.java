package com.itihas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class NoInterviewData {

    private String status;
    private String serviceRequired;
    private String staffRequired;
    private String carerType;
    private String nurseCategory;
    private String carerGender;
    private String careServiceHour;
    private String carerShift;
    private String carerShiftMorning;
    private String serviceStartDate;
    private String serviceDuration;
    private int numberOfDays;

    private String carer_name;
    private String carer_type;
    private String skills;
    private String photo;
    private String educational_certificate;

    private String experienceYears;
    private String educationDegree;
    private String noProfilePriority;

    private String referenceName;
    private String referenceNumber;
    private String carerNumber;

    private String source;
    private String aadhar_number;
    private String bgv_status;
    private String id_proof;

    private String carerWeight;
    private String carerHeight;

    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String q5;
    private String q6;
    private String q7;
    private String q8;
    private String q9;
    private String q10;
    private String q11;
    private String q12;
    private String q13;
    private String q14;
    private String q15;
    private String q16;
    private String q17;
    private String q18;
    private String q19;
    private String q20;
    private String q21;
    private String q22;
    private String q23;
    private String q24;
    private String q25;
    private String q26;
    private String q27;
    private String q28;

    private String remarks;

    private int totalMarks;
    private String scoreInterpretation;
    private String regionalNO;

    private int q4_marks;
    private int q5_marks;
    private int q6_marks;
    private int q7_marks;
    private int q8_marks;
    private int q9_marks;
    private int q10_marks;
    private int q11_marks;
    private int q12_marks;
    private int q13_marks;
    private int q14_marks;
    private int q15_marks;
    private int q16_marks;
    private int q17_marks;
    private int q18_marks;
    private int q19_marks;
    private int q20_marks;
    private int q21_marks;
    private int q22_marks;
    private int q23_marks;
    private int q24_marks;
    private int q25_marks;
    private int q26_marks;
    private int q27_marks;
    private int q28_marks;

    public NoInterviewData(
            String status,
            String serviceRequired,
            String staffRequired,
            String carerType,
            String nurseCategory,
            String carerGender,
            String careServiceHour,
            String carerShift,
            String carerShiftMorning,
            String serviceStartDate,
            String serviceDuration,
            int numberOfDays,
            String carer_name,
            String carer_type,
            String skills,
            String photo,
            String educational_certificate,
            String experienceYears,
            String educationDegree,
            String noProfilePriority,
            String referenceName,
            String referenceNumber,
            String carerNumber,
            String source,
            String aadhar_number,
            String bgv_status,
            String id_proof,
            String carerWeight,
            String carerHeight,
            String q1,
            String q2,
            String q3,
            String q4,
            String q5,
            String q6,
            String q7,
            String q8,
            String q9,
            String q10,
            String q11,
            String q12,
            String q13,
            String q14,
            String q15,
            String q16,
            String q17,
            String q18,
            String q19,
            String q20,
            String q21,
            String q22,
            String q23,
            String q24,
            String q25,
            String q26,
            String q27,
            String q28,
            String remarks,
            int totalMarks,
            String scoreInterpretation,
            String regionalNO,
            int q4_marks,
            int q5_marks,
            int q6_marks,
            int q7_marks,
            int q8_marks,
            int q9_marks,
            int q10_marks,
            int q11_marks,
            int q12_marks,
            int q13_marks,
            int q14_marks,
            int q15_marks,
            int q16_marks,
            int q17_marks,
            int q18_marks,
            int q19_marks,
            int q20_marks,
            int q21_marks,
            int q22_marks,
            int q23_marks,
            int q24_marks,
            int q25_marks,
            int q26_marks,
            int q27_marks,
            int q28_marks) {

        this.status = status;
        this.serviceRequired = serviceRequired;
        this.staffRequired = staffRequired;
        this.carerType = carerType;
        this.nurseCategory = nurseCategory;
        this.carerGender = carerGender;
        this.careServiceHour = careServiceHour;
        this.carerShift = carerShift;
        this.carerShiftMorning = carerShiftMorning;
        this.serviceStartDate = serviceStartDate;
        this.serviceDuration = serviceDuration;
        this.numberOfDays = numberOfDays;
        this.carer_name = carer_name;
        this.carer_type = carer_type;
        this.skills = skills;
        this.photo = photo;
        this.educational_certificate = educational_certificate;
        this.experienceYears = experienceYears;
        this.educationDegree = educationDegree;
        this.noProfilePriority = noProfilePriority;
        this.referenceName = referenceName;
        this.referenceNumber = referenceNumber;
        this.carerNumber = carerNumber;
        this.source = source;
        this.aadhar_number = aadhar_number;
        this.bgv_status = bgv_status;
        this.id_proof = id_proof;
        this.carerWeight = carerWeight;
        this.carerHeight = carerHeight;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
        this.q9 = q9;
        this.q10 = q10;
        this.q11 = q11;
        this.q12 = q12;
        this.q13 = q13;
        this.q14 = q14;
        this.q15 = q15;
        this.q16 = q16;
        this.q17 = q17;
        this.q18 = q18;
        this.q19 = q19;
        this.q20 = q20;
        this.q21 = q21;
        this.q22 = q22;
        this.q23 = q23;
        this.q24 = q24;
        this.q25 = q25;
        this.q26 = q26;
        this.q27 = q27;
        this.q28 = q28;
        this.remarks = remarks;
        this.totalMarks = totalMarks;
        this.scoreInterpretation = scoreInterpretation;
        this.regionalNO = regionalNO;
        this.q4_marks = q4_marks;
        this.q5_marks = q5_marks;
        this.q6_marks = q6_marks;
        this.q7_marks = q7_marks;
        this.q8_marks = q8_marks;
        this.q9_marks = q9_marks;
        this.q10_marks = q10_marks;
        this.q11_marks = q11_marks;
        this.q12_marks = q12_marks;
        this.q13_marks = q13_marks;
        this.q14_marks = q14_marks;
        this.q15_marks = q15_marks;
        this.q16_marks = q16_marks;
        this.q17_marks = q17_marks;
        this.q18_marks = q18_marks;
        this.q19_marks = q19_marks;
        this.q20_marks = q20_marks;
        this.q21_marks = q21_marks;
        this.q22_marks = q22_marks;
        this.q23_marks = q23_marks;
        this.q24_marks = q24_marks;
        this.q25_marks = q25_marks;
        this.q26_marks = q26_marks;
        this.q27_marks = q27_marks;
        this.q28_marks = q28_marks;
    }
}