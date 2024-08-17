import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    public RegistrationPage openPage () {

        // Open the page "Practice Form"
        open("/automation-practice-form");

        // Hide advertisement bars
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('.sidebar-content').remove()");

        // Check that opened page is exactly the page "Practice Form"
        $(".text-center").shouldHave(Condition.exactTextCaseSensitive("Practice Form"));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);

        return this;
    }

    public RegistrationPage setEmail(String userEmail) {
        $("#userEmail").setValue(userEmail);

        return this;
    }

    public RegistrationPage selectGender() {
        $("[for=gender-radio-1]").click();

        return this;
    }
}
