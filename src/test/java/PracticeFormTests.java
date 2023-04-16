import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll () {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void FillPracticeFormTest () {
        open("/automation-practice-form");
        $("#firstName").setValue("Slobodan");
        $("#lastName").setValue("Milosevic");
        $("#userEmail").setValue("slobodan@mail.ru");
        $(byText("Male")).click();
        //$("#gender-radio-1").
                //selectRadio("#gender-radio-1");
        $("#userNumber").setValue("+738045698755");

        $("#subjectsContainer").$("#subjectsInput").setValue("e");
        $(byText("English")).click();

       // $("#output").shouldHave(text("Grigorii"), text("g-amelin@mail.ru"),
           //     text("Some address 1"), text("Some address 2"));
        sleep(5000);
    }
}
