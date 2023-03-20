import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll () {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest () {
        open("/text-box");
        //$("[id=userName]").setValue("Grigorii")
        $("#userName").setValue("Grigorii");
        $("#userEmail").setValue("g-amelin@mail.ru");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Some address 2");
        $("#submit").scrollTo().click();

        $("#output").shouldHave(text("Grigorii"), text("g-amelin@mail.ru"),
                text("Some address 1"), text("Some address 2"));
    }
}
