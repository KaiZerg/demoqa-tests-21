package guru.qa;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {


    void cssXpathExample() {
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        // CSS
        $("[data-testid=email]").setValue("1");
        $("input[data-testid=email]").setValue("1");
        $(by("data-testid","email")).setValue("1");

        // Xpath
        $x("//*[@data-testid='email']").setValue("1");
        $x("//input[@data-testid='email']").setValue("1");


        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">
        $("[id=email]").setValue("1");
        $("#email").setValue("1");
        $("input##email").setValue("1");

        // <input type="email" class="inputtext login_form_input_box" name="email">
        $("[name=email]").setValue("1");
        $(byName("email")).setValue("1");

        // <input type="email" class="inputtext login_form_input_box">
        $("[class=inputtext][class=login_form_input_box]").setValue("1");
        $(".inputtext.login_form_input_box").setValue("1");
        $(".login_form_input_box").setValue("1");

        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("1");


        // <div class="inputtext">
        //      <input type="email" class="login_form_input_box">
        // </div>
        // нужен пробел между классами, когда общаешься через родителей
        $(".inputtext .login_form_input_box").setValue("1");

        // <div>Hello, qa.guru!</div>
        $x("//div[text()='Hello, qa.guru!']").click();
        $(byText("Hello, qa.guru!")).click();
        $(withText("llo, qa.guru!")).click();  //поиск по подстроке

    }
}
