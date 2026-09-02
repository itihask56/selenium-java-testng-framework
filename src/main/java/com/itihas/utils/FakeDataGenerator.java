package com.itihas.utils;

import net.datafaker.Faker;

public class FakeDataGenerator {

    private static Faker faker =
            new Faker();

    public static String firstName(){
        return "test"+faker.name().firstName();
    }

    public static String lastName(){
        return faker.name().lastName();
    }

    public static String phoneNumber(){
        return faker.phoneNumber()
                .cellPhone();
    }
}