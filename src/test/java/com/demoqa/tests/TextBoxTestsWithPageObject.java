package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTestsWithPageObject extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {

        textBoxPage.openPage()
                .setFullName("Ivan Ivanov")
                .setEmail("ivan.ivanov@gmail.com")
                .setCurrentAddress("USA, New Tork")
                .setPermanentAddress("Russia, Kazan")
                .submit()

                .checkResults(new String[]{
                        "Ivan Ivanov",
                        "ivan.ivanov@gmail.com",
                        "USA, New Tork",
                        "Russia, Kazan"
                });
    }

}