package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.TestDataProperties;

import org.junit.jupiter.api.Test;

public class RegistrationTestWithFakerJava extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestDataProperties testData = new TestDataProperties(); // Create an instance

    @Test
    void registrationTest() {

        registrationPage.openPage()
                .removeFixedBanner()
                .removeFooter()
                .setFirstName(testData.firstNameValue)
                .setLastName(testData.lastNameValue)
                .setUserEmail(testData.emailValue)
                .setGender(testData.genderValue)
                .setUserNumber(testData.phoneNumber)
                .setBirthDay(testData.monthValue, testData.yearValue, testData.dayValue)
                .setSubjects(testData.subjectValue)
                .setHobbies(testData.hobieValue)
                .uploadPicture(testData.fileNameValue)
                .setAddress(testData.addressValue)
                .setState(testData.stateValue)
                .setCity(testData.cityValue)
                .clickOnSubmitButton();

        registrationPage.checkOverResults("Student Name", testData.firstNameValue + " " + testData.lastNameValue)
                .checkOverResults("Student Email", testData.emailValue)
                .checkOverResults("Gender", testData.genderValue)
                .checkOverResults("Mobile", testData.phoneNumber)
                .checkOverResults("Date of Birth", testData.dayValue + " " + testData.monthValue + "," + testData.yearValue)
                .checkOverResults("Subjects", testData.subjectValue)
                .checkOverResults("Hobbies", testData.hobieValue)
                .checkOverResults("Picture", testData.fileNameValue)
                .checkOverResults("Address", testData.addressValue)
                .checkOverResults("State and City", testData.stateValue + " " + testData.cityValue);
    }
}