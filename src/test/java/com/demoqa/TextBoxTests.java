package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        //System.out.println("beforeAll()");
        //open("https://google.com");
        //Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/text-box");

        $("#userName").setValue("Ildar Gabitov");
        $("#userEmail").setValue("gabitov.tatarin@gmail.com");
        $("#currentAddress").setValue("USA, New Tork");
        $("#permanentAddress").setValue("Russia, Kazan");
        $("#submit").click();

        $("#output #name").shouldHave(text("Ildar Gabitov"));
        $("#output #email").shouldHave(text("gabitov.tatarin@gmail.com"));
        $("#output #currentAddress").shouldHave(text("USA, New Tork"));
        $("#output #permanentAddress").shouldHave(text("Russia, Kazan"));

    }
}
