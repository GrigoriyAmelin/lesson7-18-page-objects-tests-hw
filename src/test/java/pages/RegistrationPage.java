package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEX = "Practice Form";

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");

    public RegistrationPage openPage () {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('.sidebar-content').remove()");
        $(".text-center").shouldHave(Condition.exactTextCaseSensitive(TITLE_TEX));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
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

    public RegistrationPage setPhoneNumber(String phoneNumber) {
        $("#userNumber").setValue(phoneNumber);
        return this;
    }

    public RegistrationPage selectSubject(String sign, String subject) {
        $("#subjectsContainer").$("#subjectsInput").setValue(sign);
        $(byText(subject)).click();
        return this;
    }
}
