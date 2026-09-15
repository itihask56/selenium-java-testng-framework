package com.itihas.testdata;

import java.util.HashMap;
import java.util.Map;

public class QuotationDataBuilder {

    public static Map<String, String> build() {
        Map<String, String> values = new HashMap<>();

        values.put("Carer1 Type - Quote", "Nurse");
        values.put("Carer1 Shift - Q", "At Home (24 Hrs)");
        values.put("Carer1 Price (Per Day)", "10");
        values.put("Carer1 No of Days", "5");
        values.put("Carer1 Final Price", "50");
        values.put("Carer1 Approval", "Accepted");
        values.put("Total Price (Per Day)", "10");
        values.put("Total Final Price", "50");
        values.put("Advance Amount", "10");
        values.put("Share Quotation ", "No");
        values.put("Reason", "");

        return values;

    }
}
