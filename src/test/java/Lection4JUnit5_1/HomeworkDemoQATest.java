package Lection4JUnit5_1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.example.dto.PageUrl;
import com.example.tests.web.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomeworkDemoQATest extends BaseTest {

    // todo добавьте нужную аннотацию, чтобы у теста появилось описание в консоли при запуске.
    //  Пример: "Проверка заголовка страницы"
    @Test
    void checkPageTitle() {
        String expectedTitle = "DEMOQA";
        String actualTitle = $("head title").getOwnText();
        Assertions.assertTrue(actualTitle.contains(expectedTitle),
                "Заголовок страницы должен содержать 'DEMOQA'");
    }

    // todo добавьте нужную аннотацию, чтобы тест не запускался
    @Test
    void disabledTestExample() {
        Assertions.fail("Этот тест не должен запускаться!");
    }


    // todo Добавьте нужную аннотацию со значениями ниже, чтобы тест заработал
    //  "Elements", "Forms", "Alerts, Frame & Windows", "Widgets", "Interactions", "Book Store Application"
    @ParameterizedTest(name = "Проверка наличия карточки: {0}")
    void checkCardExists(String cardName) {
        ElementsCollection cards = $$("div.card-body");
        boolean isCardPresent = cards.stream().anyMatch(card -> card.$("h5").text().equals(cardName));
        Assertions.assertTrue(isCardPresent, "Карточка '" + cardName + "' должна присутствовать на странице");
    }

    // todo добавьте сюда нужную аннотацию, которая будет содержать значение "SINGLE"
    //  затем в консоли с помощью команды mvn test -Dgroups=SINGLE запустите тест
    //  Убедитесь что запустился только 1 тест
    @Test
    void clickElementsCard() {
        SelenideElement elementsCard = $$("div.card-body").find(Condition.text("Elements"));
        elementsCard.click();

        Selenide.Wait().until(webDriver -> webDriver.getCurrentUrl().contains("/elements"));
        Assertions.assertTrue(
                Selenide.webdriver().driver().url().contains("/elements"),
                "URL должен содержать '/elements' после клика"
        );
    }

    //todo Добавьте нужную аннотацию со значениями ниже, чтобы тест заработал
    // "Elements | elements",
    // "Forms | forms",
    // "Alerts, Frame & Windows | alerts",
    // "Widgets | widgets",
    // "Interactions | interaction",
    // "Book Store Application | books"
    @ParameterizedTest(name = "Проверка URL для карточки: {0} → должен содержать '{1}'")
    void checkCardNavigation(String cardName, String expectedUrlFragment) {
        // Находим карточку по названию и кликаем
        SelenideElement targetCard = $$("div.card-body").find(Condition.text(cardName));
        targetCard.click();

        // Проверяем, что URL содержит ожидаемый фрагмент
        String currentUrl = Selenide.webdriver().driver().url();
        Assertions.assertTrue(
                currentUrl.contains(expectedUrlFragment),
                String.format("URL '%s' должен содержать фрагмент '%s'", currentUrl, expectedUrlFragment)
        );
    }


    //todo Добавьте нужную аннотацию чтобы тест заработал
    @ParameterizedTest(name = "Проверка URL для карточки: {0} → должен содержать '{1}'")
    void checkCardNavigation(String cardName, PageUrl pageUrl) {
        // Находим карточку по названию и кликаем
        SelenideElement targetCard = $$("div.card-body").find(Condition.text(cardName));
        targetCard.click();

        // Проверяем, что URL содержит ожидаемый фрагмент
        String currentUrl = Selenide.webdriver().driver().url();
        Assertions.assertTrue(
                currentUrl.contains(pageUrl.getEndPoint()),
                String.format("URL '%s' должен содержать фрагмент '%s'", currentUrl, pageUrl)
        );
    }
}
