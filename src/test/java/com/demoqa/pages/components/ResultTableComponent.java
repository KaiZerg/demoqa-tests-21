package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    SelenideElement tableField = $(".table-responsive");
    public void checkResult(String field, String value) {

        tableField.$(byText(field)).parent().shouldHave(text(value));
    }
}