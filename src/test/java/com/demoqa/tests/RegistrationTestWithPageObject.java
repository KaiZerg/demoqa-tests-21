package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationTestWithPageObject extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setUserEmail("alex@egorov.com")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setBirthDate("14", "July", "2008")
                .setSubjects("Math")
                .setHobbies("Sports")
                .uploadPicture("cat.jpg")
                .setAddress("USA, New York")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmitBtn()

                .checkResults(new String[][]{
                        {"Student Name", "Alex Egorov"},
                        {"Student Email", "alex@egorov.com"},
                        {"Gender", "Other"},
                        {"Mobile", "1234567890"},
                        {"Date of Birth", "14 July,2008"},
                        {"Subjects", "Maths"},
                        {"Hobbies", "Sports"},
                        {"Picture", "cat.jpg"},
                        {"Address", "USA, New York"},
                        {"State and City", "NCR Delhi"}
                });

    }

    @Test
    void successfulRegistrationMinimalTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setGender("Other")
                .setUserNumber("1234567890")
                .clickSubmitBtn()

                .checkResults(new String[][]{
                        {"Student Name", "Alex Egorov"},
                        {"Gender", "Other"},
                        {"Mobile", "1234567890"}
                });
    }
}