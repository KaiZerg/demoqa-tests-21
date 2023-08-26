package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataProperties {

    private Faker fakerEn;

    public String firstNameValue,
            lastNameValue,
            emailValue,
            genderValue,
            phoneNumber,
            monthValue,
            yearValue,
            dayValue,
            subjectValue,
            hobieValue,
            fileNameValue,
            addressValue,
            stateValue,
            cityValue;

    public TestDataProperties() {
        fakerEn = new Faker(new Locale("en"));
        firstNameValue = TestDataMethods.getRandomFirstName(fakerEn);
        lastNameValue = TestDataMethods.getRandomLastName(fakerEn);
        emailValue = TestDataMethods.getRandomEmail(fakerEn);
        genderValue = TestDataMethods.getRandomGender();
        phoneNumber = TestDataMethods.getRandomPhoneNumber(fakerEn);
        monthValue = TestDataMethods.getRandomMonth();
        yearValue = TestDataMethods.getRandomYear();
        dayValue = TestDataMethods.getRandomDay();
        subjectValue = TestDataMethods.getRandomSubject();
        hobieValue = TestDataMethods.getRandomHobie();
        fileNameValue = "cat.jpg";
        addressValue = TestDataMethods.getRandomAddress(fakerEn);
        stateValue = TestDataMethods.getRandomState();
        cityValue = TestDataMethods.getRandomCity(stateValue);
    }
}