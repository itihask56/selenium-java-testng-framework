package com.itihas.testdata;

import java.util.HashMap;
import java.util.Map;

public class LeadScreeningDataBuilder {

    public static Map<String,String> build(){
        Map<String, String> values = new HashMap<>();

        values.put("Service Required", "Carer");
        values.put("Staff Required", "1");
        values.put("Service Start Date", "15-09-2026");
        values.put("For how long do you need our services?", "Days");
        values.put("Number Of Days", "5");
        values.put("Any other specific requirement?", "");
        values.put("Nursing Assessment Type", "Virtual Nursing Assessment");
        values.put("Nursing Assessment Date", "15-09-2026");
        values.put("Nursing Assessment Time slot", "07:35 PM");
        values.put("Nursing assessment at same adress?", "yes");
        values.put("Remarks", "asdfg");
        values.put("Assign to Central NO", "namrata.patra@emoha.com");
        values.put(
                "Home Address",
                "Mararikulam Railway Station Road, Mararikulam Railway Station Road, Valavanadu, Mararikulam, Kerala, India"
        );
        values.put("City", "Mararikulam");
        values.put("State", "Kerala");
        values.put("Pincode", "688522");
        values.put("Carer1 type", "Nurse");
        values.put("Carer1 Gender", "Male");
        values.put("Service Hours (Carer 1)", "At Home (24 Hrs)");
        values.put("Carer1 shift", "");
        values.put("Carer1 shift timings", "");
        return values;
    }
}
