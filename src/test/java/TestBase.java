import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll () {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1266x668";
        // Configuration.holdBrowserOpen = true;
    }
}
