package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.RegistrationPage;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeAll(){
        Configuration.browser = System.getProperty("browser", "chrome");

        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = "https://user1:1234@"+System.getProperty("selenoidUrl")+"/wd/hub/";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
    @BeforeEach
    void beforeEach(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


}
