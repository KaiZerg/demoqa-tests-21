package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    ResultTableComponent resultTable = new ResultTableComponent();
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureUploader = $("#uploadPicture"),
            setAddress = $("#currentAddress"),

            state = $("#state"),

            stateInput = $("#stateCity-wrapper #state"),

            city = $("#city"),

            cityInput = $("#stateCity-wrapper #city"),

            submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }
    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendar.setDate(day, month, year);

        return this;
    }
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage uploadPicture(String value) {
        pictureUploader.uploadFromClasspath(value);

        return this;
    }
    public RegistrationPage setAddress(String value) {
        setAddress.setValue(value);

        return this;
    }
    public RegistrationPage setState(String value) {
        state.click();
        stateInput.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setCity(String value) {
        city.click();
        cityInput.$(byText(value)).click();

        return this;
    }
    public RegistrationPage clickSubmitBtn() {
        submitButton.click();

        return this;
    }

    public void checkResults(String[][] values) {

        for (String[] valuePair : values
        ) {
            resultTable.checkResult(valuePair[0], valuePair[1]);
        }

    }

}