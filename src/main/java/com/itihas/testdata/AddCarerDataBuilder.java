package com.itihas.testdata;

import com.itihas.dto.request.AddCarerRequest;
import com.itihas.utils.FakeDataGenerator;

import java.util.Arrays;
import java.util.List;

public class AddCarerDataBuilder {

    public static AddCarerRequest build() {
        String firstName = FakeDataGenerator.firstName();
        String phoneNumber = FakeDataGenerator.phoneNumber();
        String aadhaarNumber = "44"+FakeDataGenerator.phoneNumber();

        List<String> preferredCities = Arrays.asList(
                "Delhi",
                "Gurugram",
                "Mararikulam"
        );

        return new AddCarerRequest(
                 firstName,
                 phoneNumber,
                "Attendant",
                "GDA",
                "Male",
                "34",
                "West",
                "2",
                "Tracheostomy Care, Ventilator Care",
                 aadhaarNumber,
                "Direct",
                "Hindi,Bengali,Kanada,Malyalam",
                preferredCities,
                false,
                "Mararikulam",
                "https://emoha-production.s3.ap-south-1.amazonaws.com/aws_gallery/b2151e86-a439-47ab-9473-b99d10dd18cd_image.png",
                "https://emoha-production.s3.ap-south-1.amazonaws.com/aws_gallery/b2151e86-a439-47ab-9473-b99d10dd18cd_image.png",
                "https://emoha-production.s3.ap-south-1.amazonaws.com/aws_gallery/b88efa40-dfd7-434f-9be8-8b6d884ed808_test-ride-confirmation.jpg",
                "https://emoha-production.s3.ap-south-1.amazonaws.com/aws_gallery/cead3c88-a8b3-40a4-9e96-3f1f5aa87084_StatementofAccount_194503473.pdf"
        );
    }
}
