import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
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
        // Open the page "Practice Form"
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // Check that opened page is exactly the page "Practice Form"
        $(".main-header").shouldHave(Condition.exactTextCaseSensitive("Practice Form"));

        // Fill in the form fields
        $("#firstName").setValue("Slobodan");
        $("#lastName").setValue("Milosevic");
        $("#userEmail").setValue("slobodan@mail.ru");
        $(byText("Male")).click();
        //$("#gender-radio-1").
                //selectRadio("#gender-radio-1");
        $("#userNumber").setValue("7380456987");

        // Choose a subject in Search drop-down menu
        $("#subjectsContainer").$("#subjectsInput").setValue("e");
        $(byText("English")).click();
        $("#subjectsContainer").$("#subjectsInput").setValue("ar");
        $(byText("Arts")).click();

        // Entering personal subject todo
        $("#subjectsContainer").$("#subjectsInput").setValue("cars");

        // Choose a Hobby check-box
        $("#hobbies-checkbox-1").sibling(0).click();
        $("#hobbies-checkbox-2").sibling(0).click();
        $("#hobbies-checkbox-3").sibling(0).click();
        $("#hobbies-checkbox-2").sibling(0).click();

        // Check that personal subject doesn't exit in the list of subjects
        $("#subjectsContainer").shouldNotHave(exactTextCaseSensitive("cars")).
                shouldHave(text("English")).shouldHave(text("Arts"));

        // Set Current Address
        $("[placeholder='Current Address']").setValue("101000 Novi Sad, Serbija\nCara Dusana 83. sprat 243");

        // Select State and City
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();

        // Open button "Submit" and check that modal window is opened
        $("#submit").click();
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        // Check the correctness of the data in modal window
        $(".table-responsive").$(byText("Student Name")).parent()
                .shouldHave(text("Slobodan Milosevic"));
        $(".table-responsive").$(byText("Student Email")).parent()
                .shouldHave(text("slobodan@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent()
                .shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent()
                .shouldHave(text("7380456987"));

        $(".table-responsive").$(byText("Subjects")).parent()
                .shouldHave(text("English, Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent()
                .shouldHave(text("Sports, Music"));

        $(".table-responsive").$(byText("Address")).parent()
                .shouldHave(text("101000 Novi Sad, Serbija Cara Dusana 83. sprat 243"));
        $(".table-responsive").$(byText("State and City")).parent()
                .shouldHave(text("Haryana Panipat"));

        // Close a modal window
        $("#closeLargeModal").click();

        sleep(5000);
    }
}
