package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class GithubTest {
    public final SelenideElement githubSearch = $("input[name=q]");

    @Test
    void githubSearch() throws MalformedURLException {
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("allure", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.browser = System.getProperty("browser_name", "firefox");
        Configuration.browserVersion = System.getProperty("browser_version", "98.0");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий Selenide", () -> {
            githubSearch.click();
            githubSearch.setValue("Selenide");
            githubSearch.pressEnter();
        });

        step("Проверяем, что первый в списке Selenide", () -> {
            $$(".repo-list .repo-list-item").first().shouldHave(Condition.text("selenide/selenide"));
        });
    }    @Test
    void githubSearch2() throws MalformedURLException {
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("allure", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.browser = System.getProperty("browser_name", "firefox");
        Configuration.browserVersion = System.getProperty("browser_version", "98.0");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий Selenide", () -> {
            githubSearch.click();
            githubSearch.setValue("Selenide");
            githubSearch.pressEnter();
        });

        step("Проверяем, что первый в списке Selenide", () -> {
            $$(".repo-list .repo-list-item").first().shouldHave(Condition.text("selenide/selenide"));
        });
    }    @Test
    void githubSearch3() throws MalformedURLException {
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("allure", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.browser = System.getProperty("browser_name", "firefox");
        Configuration.browserVersion = System.getProperty("browser_version", "98.0");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий Selenide", () -> {
            githubSearch.click();
            githubSearch.setValue("Selenide");
            githubSearch.pressEnter();
        });

        step("Проверяем, что первый в списке Selenide", () -> {
            $$(".repo-list .repo-list-item").first().shouldHave(Condition.text("selenide/selenide"));
        });
    }    @Test
    void githubSearch4() throws MalformedURLException {
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("allure", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.browser = System.getProperty("browser_name", "firefox");
        Configuration.browserVersion = System.getProperty("browser_version", "98.0");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий Selenide", () -> {
            githubSearch.click();
            githubSearch.setValue("Selenide");
            githubSearch.pressEnter();
        });

        step("Проверяем, что первый в списке Selenide", () -> {
            $$(".repo-list .repo-list-item").first().shouldHave(Condition.text("selenide/selenide"));
        });
    }
}
