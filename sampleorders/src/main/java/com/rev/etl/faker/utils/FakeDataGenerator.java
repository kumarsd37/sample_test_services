package com.rev.etl.faker.utils;

import com.github.javafaker.Faker;

public class FakeDataGenerator {

    private static final Faker faker = new Faker();


    public static String getFirstName(){
        return faker.name().firstName();
    }

    public static String getLastName(){
        return faker.name().lastName();
    }

    public static String getStreetAddress(){
        return faker.address().streetAddress();
    }

    public static String getCity(){
        return faker.address().city();
    }

    public static String getCountry(){
        return faker.address().country();
    }

    public static String getZipcode(){
        return faker.address().zipCode();
    }

    public static String getLatitude(){
        return faker.address().latitude();
    }

    public static String getLongitude(){
        return faker.address().longitude();
    }

    public static String getPhoneNumber(){
        return faker.phoneNumber().cellPhone();
    }
}
