package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEX = "Practice Form";

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderSelector = $("#genterWrapper"),
            userPhoneInput = $("#userNumber"),
            subjectInput = $("#subjectsContainer").$("#subjectsInput");

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
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        genderSelector.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber) {
        userPhoneInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage selectSubject(String sign, String subject) {
        subjectInput.setValue(sign);
        $(byText(subject)).click();
        return this;
    }
}
