package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.TestDataProperties;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Feature("Проверка регистрации - с генерацией данных")
@Owner("KaiZerg")
public class RegistrationTestWithFakerJava extends RemoteTestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestDataProperties testData = new TestDataProperties();

    @Test
    @Tag("remote")
    @DisplayName("Успешная регистрация при сабмите в форму авторизации - с генерацией данных")
    @Story("Позитивная проверка авторизации")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value="GitHub link", url="https://github.com/KaiZerg/demoqa-tests-21/tree/remote_test")
    void registrationTest() {
        step("Открываем страницу с формой авторизации", () -> {
            registrationPage.openPage()
                    .removeFixedBanner()
                    .removeFooter();
        });
        step("Заполняем форму", () -> {
            registrationPage.setFirstName(testData.firstNameValue)
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
                    .setCity(testData.cityValue);
        });
        step("Делаем сабмит", () -> registrationPage.clickOnSubmitButton());
        step("Проверяем сохраненные данные", () -> {
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
        });
    }
}