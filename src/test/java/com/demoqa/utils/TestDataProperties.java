package com.demoqa.utils;

import com.github.javafaker.Faker;

import static com.demoqa.utils.TestDataMethods.*;

import java.util.Locale;

public class TestDataProperties {

    static Faker fakerEn = new Faker(new Locale("en"));

    public static String firstNameValue = getRandomFirstName(),
            lastNameValue = getRandomLastName(),
            emailValue = getRandomEmail(),
            genderValue = getRandomGender(),
            phoneNumber = getRandomPhoneNumber(),
            monthValue = getRandomMonth(),
            yearValue = getRandomYear(),
            dayValue = getRandomDay(),
            subjectValue = getRandomSubject(),
            hobieValue = getRandomHobie(),
            fileNameValue = "cat.jpg",
            addressValue = getRandomAddress(),
            stateValue = getRandomState(),
            cityValue = getRandomCity(stateValue);
}
