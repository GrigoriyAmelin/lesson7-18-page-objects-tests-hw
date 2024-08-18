import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.SelectRadio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {

    @Test
    void FillPracticeFormTest () {

        String firstName = "Slobodan",
                lastName = "Milosevic",
                userEmail = "slobodan@mail.ru",
                phoneNumber = "7380456987",
                signLetter1 = "e",
                subject1 = "English",
                signLetter2 = "ar",
                subject2 = "Arts";

        new RegistrationPage().
                openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setEmail(userEmail).
                selectGender().
                setPhoneNumber(phoneNumber).
                selectSubject(signLetter1, subject1).
                selectSubject(signLetter2, subject2);

        // Select Date of birth
        //$("#dateOfBirth").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOptionByValue("1980");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        // Choose a subject in Search drop-down menu


        // Entering personal subject
        $("#subjectsContainer").$("#subjectsInput").setValue("cars");

        // Choose a Hobby check-box
        $("#hobbies-checkbox-1").sibling(0).click();
        $("#hobbies-checkbox-2").sibling(0).click();
        $("#hobbies-checkbox-3").sibling(0).click();
        $("#hobbies-checkbox-2").sibling(0).click();

        // Upload file for Picture - Option #1
        //$("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        // Upload file for Picture - Option #2
        $("#uploadPicture").uploadFromClasspath("img/2.jpg");

        // Check that personal subject doesn't exit in the list of subjects
        $("#subjectsContainer").shouldNotHave(exactTextCaseSensitive("cars")).
                shouldHave(text("English")).shouldHave(text("Arts"));

        // Set Current Address
        $("[placeholder='Current Address']").setValue("101000 Novi Sad, Srbija\nCara Dusana 83. sprat 243");

        // Select State and City
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();

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
        $(".table-responsive").$(byText("Date of Birth")).parent()
                .shouldHave(text("30 April,1980"));
        $(".table-responsive").$(byText("Subjects")).parent()
                .shouldHave(text("English, Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent()
                .shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Hobbies")).parent()
                .shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).parent()
                .shouldHave(text("2.jpg"));
        $(".table-responsive").$(byText("Address")).parent()
                .shouldHave(text("101000 Novi Sad, Srbija\nCara Dusana 83. sprat 243"));
        $(".table-responsive").$(byText("State and City")).parent()
                .shouldHave(text("Haryana Panipat"));

        // Close a modal window
        $("#closeLargeModal").click();
    }
}
