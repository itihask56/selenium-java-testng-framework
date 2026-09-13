package com.itihas.testdata;

import java.util.HashMap;
import java.util.Map;

public class QuotationDataBuilder {

    public static Map<String, String> build() {
        Map<String, String> values = new HashMap<>();

        values.put("Carer1 Type - Quote", "Nurse");
        values.put("Carer1 Shift - Q", "Visiting (12 Hrs)");
        values.put("Carer1 Price (Per Day)", "100");
        values.put("Carer1 No of Days", "5");
        values.put("Carer1 Final Price", "500");
        values.put("Carer1 Approval", "");
        values.put("Total Price (Per Day)", "100");
        values.put("Total Final Price", "500");
        values.put("Advance Amount", "100");
        values.put("Share Quotation ", "No");
        values.put("Reason", "");

        return values;

    }
}
