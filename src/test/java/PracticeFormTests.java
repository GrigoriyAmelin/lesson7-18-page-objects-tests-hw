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
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1266x668";
        // Configuration.holdBrowserOpen = true;
    }

    @Test
    void FillPracticeFormTest () {
        // Open the page "Practice Form"
        open("/automation-practice-form");

        // Hide advertisement bars
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('.sidebar-content').remove()");

        sleep(1000);

        // Check that opened page is exactly the page "Practice Form"
        $(".text-center").shouldHave(Condition.exactTextCaseSensitive("Practice Form"));

        // Fill in the form fields
        $("#firstName").setValue("Slobodan");
        $("#lastName").setValue("Milosevic");
        $("#userEmail").setValue("slobodan@mail.ru");

        // Universal method to select gender not looking at local language instead of $(byText("Male")).click();
        //$("#gender-radio-1").parent().click();

        $("[for=gender-radio-1]").click();

        //$("#gender-radio-1").
        //selectRadio("#gender-radio-1");
        $("#userNumber").setValue("7380456987");

        //$("#dateOfBirth").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOptionByValue("1980");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        sleep(1000);

        // Choose a subject in Search drop-down menu
        $("#subjectsContainer").$("#subjectsInput").setValue("e");
        $(byText("English")).click();
        $("#subjectsContainer").$("#subjectsInput").setValue("ar");
        $(byText("Arts")).click();

        // Entering personal subject todo
        $("#subjectsContainer").$("#subjectsInput").setValue("cars");

        sleep(1000);

        // Choose a Hobby check-box
        $("#hobbies-checkbox-1").sibling(0).click();
        $("#hobbies-checkbox-2").sibling(0).click();
        $("#hobbies-checkbox-3").sibling(0).click();
        $("#hobbies-checkbox-2").sibling(0).click();

        // Upload file for Picture - Option #1
        //$("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        // Upload file for Picture - Option #2
        $("#uploadPicture").uploadFromClasspath("img/2.jpg");

        sleep(1000);

        // Check that personal subject doesn't exit in the list of subjects
        $("#subjectsContainer").shouldNotHave(exactTextCaseSensitive("cars")).
                shouldHave(text("English")).shouldHave(text("Arts"));

        // Set Current Address
        $("[placeholder='Current Address']").setValue("101000 Novi Sad, Serbija\nCara Dusana 83. sprat 243");

        sleep(1000);

        // Select State and City
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();

        sleep(1000);

        // Open button "Submit" and check that modal window is opened
        $("#submit").click();
        $(".modal-dialog").should(appear);
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

        sleep(1000);
    }
}
