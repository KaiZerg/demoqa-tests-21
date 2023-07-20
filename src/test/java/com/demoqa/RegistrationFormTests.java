package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // FirstName
        $("#userName-wrapper #firstName").setValue("Ildar");

        // LastName
        $("#userName-wrapper #lastName").setValue("Gabitov");

        // Email
        $("#userEmail-wrapper #userEmail").setValue("gabitov.ildar@gmail.com");

        // Gender
        $("label[for='gender-radio-1']").click();

        // Mobile 10 digits
        $("#userNumber-wrapper #userNumber").setValue("9861234567");

        // Date
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--024").click(); // Click on the 24th day

        // Subjects
        $("#subjectsInput").setValue("Maths");
        $(".subjects-auto-complete__option").shouldHave(text("Math")).click();
        // subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3
        //$(".subjects-auto-complete__input").setValue("math");

        // Hobbies buttons
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-3']").click();

        // Picture
        $("#uploadPicture").uploadFile(new File("src/test/resources/cat.jpg"));
        //$("#uploadPicture").uploadFile(new File("D:\\cat.jpg"));

        // CurrentAddress
        $("#currentAddress").setValue("USA, New Tork");


        // Select State
        $("#state").click();
        $(byText("NCR")).click();

        // Select City
        $("#city").click();
        $(byText("Delhi")).click();

        // submit
        $("#submit").click();

        // Проверки
        $(".modal-body");

        // Проверка каждой строки результирующей таблицы
        verifyCellValue("Student Name", "Ildar Gabitov");
        verifyCellValue("Student Email", "gabitov.ildar@gmail.com");
        verifyCellValue("Gender", "Male");
        verifyCellValue("Mobile", "9861234567");
        verifyCellValue("Date of Birth", "24 February,1990");
        verifyCellValue("Subjects", "Maths");
        verifyCellValue("Hobbies", "Sports, Music");
        verifyCellValue("Picture", "cat.jpg");
        verifyCellValue("Address", "USA, New Tork");
        verifyCellValue("State and City", "NCR Delhi");
    }

    // Method to verify cell value in the table
    private static void verifyCellValue(String label, String value) {
        // Find the cell based on the label in the first column
        String xpath = String.format("//tr[td[text()='%s']]/td[2]", label);
        $(By.xpath(xpath)).shouldHave(text(value));
    }


}
