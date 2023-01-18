package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class GithubTest {
    public final SelenideElement githubSearch = $("input[name=q]");

    @Test
    void githubSearch(){
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("allure", new AllureSelenide());

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
