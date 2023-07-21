package com.demoqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests  extends TestBase {

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#userName-wrapper #firstName").setValue("Ildar");

        $("#userName-wrapper #lastName").setValue("Gabitov");

        $("#userEmail-wrapper #userEmail").setValue("gabitov.ildar@gmail.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber-wrapper #userNumber").setValue("9861234567");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--024").click(); // Click on the 24th day

        $("#subjectsInput").setValue("Maths");
        $(".subjects-auto-complete__option").shouldHave(text("Math")).click();

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("cat.jpg");

        $("#currentAddress").setValue("USA, New York");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();


        // Проверки
        verifyCellValue("Student Name", "Ildar Gabitov");
        verifyCellValue("Student Email", "gabitov.ildar@gmail.com");
        verifyCellValue("Gender", "Male");
        verifyCellValue("Mobile", "9861234567");
        verifyCellValue("Date of Birth", "24 February,1990");
        verifyCellValue("Subjects", "Maths");
        verifyCellValue("Hobbies", "Music");
        verifyCellValue("Picture", "cat.jpg");
        verifyCellValue("Address", "USA, New York");
        verifyCellValue("State and City", "NCR Delhi");
    }

    private static void verifyCellValue(String label, String value) {
        // Find the cell based on the label in the first column
        String xpath = String.format("//tr[td[text()='%s']]/td[2]", label);
        $(By.xpath(xpath)).shouldHave(text(value));
    }

}
