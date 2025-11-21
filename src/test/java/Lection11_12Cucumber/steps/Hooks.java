package Lection11_12Cucumber.steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    @BeforeAll
    public static void setupConfig() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 20000;
        //2. Добавила строчку ниже, тк без неё тесты не проходятся, ибо по умолчанию этот параметра = "normal", а значит ждёт пока загрущится всё — DOM, стили, скрипты, рекламу.
        Configuration.pageLoadStrategy = "eager"; // ← КЛЮЧЕВОЙ ПАРАМЕТР! меняем стратегию загрузки, ждёт только DOM ready → страница интерактивна, даже если реклама не загрузилась
        Configuration.reportsFolder = "target/selenide/reports"; //из лекции

        // Прописываем победу над DPI-драконом: передаём ChromeOptions через capabilities (нужно передать аргументы запуска Chrome через Selenide через системные свойства или через Configuration.browserCapabilities)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=1");
        options.addArguments("--high-dpi-support=1");
        //options.addArguments("--window-size=1920,1080"); --думала, потребуется, но нет, хватило в конфигурациях прописать
        Configuration.browserCapabilities = options;

        System.out.println(">>> [BeforeAll] Браузер настроен глобально.");
    }

    @After
    public void closeBrowser() {
        // Закрытие браузера после каждого теста
        closeWebDriver();
        System.out.println(">>> [AfterEach] Браузер закрыт.");
    }
}
