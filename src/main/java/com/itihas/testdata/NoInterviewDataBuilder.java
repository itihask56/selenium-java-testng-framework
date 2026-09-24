package com.itihas.testdata;

import com.itihas.dto.request.NoInterviewData;
import com.itihas.dto.request.NoInterviewRequest;

public class NoInterviewDataBuilder {

    private NoInterviewDataBuilder() {}

    public static NoInterviewRequest build(String taskUuid) {

        NoInterviewData data =
                new NoInterviewData(

                        "Approved",
                        "Carer",
                        "1",
                        "Nurse",
                        "ANM",
                        "Male",
                        "Visiting (12 Hrs)",
                        "Morning Shift",
                        "7:00 AM to 7:00 PM",
                        "2026-08-05T18:32:34.705Z",
                        "Days",
                        5,

                        "test carer Jordane",
                        "Attendant",
                        "asdfghj",
                        "photo-url",
                        "certificate-url",

                        "2",
                        "GNM",
                        "2",

                        "Itihas",
                        "4444098767",
                        "7489033475",

                        "Direct",
                        "4444266-701-1941",
                        "Verification Pending",
                        "id-proof-url",

                        "45",
                        "8'6\"",

                        "Zxdfg",
                        "sdfghj",
                        "sdfghj",

                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "I will stop it and inform the nursing officer immediately",
                        "I will protect the elder and report it to Nursing officer",
                        "I will not share any details and will inform my nursing officer and family",

                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",
                        "Excellent",

                        "sdfghjk",

                        100,
                        "Strongly Recommended",
                        "jayshree.patil@emoha.com",

                        4,4,4,4,4,4,4,4,4,4,
                        4,4,4,4,4,4,4,4,4,4,
                        4,4,4,4,4
                );

        return new NoInterviewRequest(
                "noInterview",
                taskUuid,
                data
        );
    }
}