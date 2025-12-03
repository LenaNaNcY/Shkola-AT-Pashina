package com.example.Allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Epic("Дз по Allure")

public class SelenideTestsAllure {

        @BeforeAll
static void setupConfig() {
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

    @BeforeEach
    @Step("Открываем главную страницу DemoQA")
    void openBrowser() {
        // Открытие главной страницы перед каждым тестом
        open("https://demoqa.com");
        System.out.println(">>> [BeforeEach] Открыта главная страница DemoQA.");
    }

    @AfterEach
    @Step("Закрываем браузер")
    void closeBrowser() {
        // Закрытие браузера после каждого теста
        closeWebDriver();
        System.out.println(">>> [AfterEach] Браузер закрыт.");
    }

    @AfterAll
    static void tearDownAll() {
        // Опционально: можно очистить кэш, отчеты и т.д.
        System.out.println(">>> [AfterAll] Все тесты завершены. Глобальная очистка.");
    }

    @Step("Кол-во пунктов на форме равно шести")
    public void countElements() {
        ElementsCollection menuTabs = $$x("//div[@class='card mt-4 top-card']"); //ищем коллекцию из 6ти элементов
        menuTabs.shouldHave(size(6)); //проверяем, что в коллекции 6 эл-тов; в лекции кстати такого не помню, искала гуглом
    }

    @Step("В меню слева отображаются следующие подпункты: \"Browser Windows\", \"Alerts\", \"Frames\", \"Nested Frames\", \"Modal Dialogs\"")
    public void countElements2() {
        $(byXpath("//h5[text()='Alerts, Frame & Windows']")).click(); //клик по меню "Alerts, Frame & Windows"
        ElementsCollection subMenuItems = $$(byXpath("//div[@class='element-list collapse show']//span")); // получаем коллекцию подпунктов меню
        subMenuItems.shouldHave(texts("Browser Windows", "Alerts", "Frames", "Nested Frames", "Modal Dialogs")); //проверяем по тексту
    }

    @Feature("Фреймы")
    @Story("Нестед фреймс")
    @Description("Проверяем фреймы в меню \"Alerts, Frame & Windows\"")
    @Test
    public void TK_1() {

        //Шаг 1
        countElements();
        //Шаг 2
        countElements2();

        //Шаг 3
        $(byText("Nested Frames")).click(); //клик по пункту "Nested Frames"
        $(By.id("framesWrapper")).shouldHave(text("Sample Nested Iframe page")); //проверяем, что там есть текст

        //Шаг 4 - переходы во фреймы
        switchTo().frame($(byId("frame1"))); //переходим сначала в родительский фрейм
        SelenideElement childFrame = $(byTagName("iframe")); //находим дочерний по тэгу, тк id там нет и ваще кроме текста и тегов ничего нет
        switchTo().frame(childFrame); //проваливаемся в дочерний
        $(byTagName("body")).shouldHave(text("Child Iframe")); //проверяем содержимый текст

        //Шаг5 - фреймы
        switchTo().parentFrame(); // возврат на уровень выше — в parent iframe
        $(byTagName("body")).shouldHave(text("Parent frame")); //проверяем содержимый текст

        //Шаг 6
        switchTo().defaultContent(); // возвращаемся в основной документ
        SelenideElement pageFrames = $(byId("framesWrapper"));
        pageFrames.shouldHave(text("Sample Nested Iframe page")); //проверяем содержимый текст

    }

    @Feature("Виджетс")
    @Story("Прогресс бар")
    @Description("Проверяем, что Progress Bar в меню \"Widgets\" остановится на 30%")
    @Test
    public void TK_2() {
        //Шаг 1 - сайт откроется сам, ОР тут нет, поэтому кода нет

        //Шаг 2 - клик по меню "Widgets"
        $(byXpath("//h5[text()='Widgets']")).click();

        //Шаг 3 - клик по пункту "Progress Bar"
        $(byText("Progress Bar")).click(); // дописываем скролл перед кликом
        $(byCssSelector("#startStopButton")).shouldHave(text("Start"));

        //Шаг 4 - клик по кнопке "Start"
        $(byCssSelector("#startStopButton")).click();
        $("#startStopButton").shouldHave(text("Stop"));

        //Шаг 5 - клик по кнопке "Stop" при достижении прогресс баром 30%
        $x("//*[@id='progressBar']/div").shouldHave(Condition.attribute("aria-valuenow", "30"));// Ждём, пока прогресс-бар станет "30%"
        // Как только он стал 30% — кликаем по кнопке "Stop"
        $(byCssSelector("#startStopButton")).click();

    }

    @Feature("Виджетс")
    @Story("Множественный выбор")
    @Description("Проверяем выбор вариантов в выпадающих списках")
    @Test
    public void TK_3() {
        //Шаг 1 - сайт откроется сам, ОР тут нет, поэтому кода нет

        //Шаг 2 - клик по меню "Widgets"
        $(byXpath("//h5[text()='Widgets']")).click();

        //Шаг 3 - клик по пункту "Select Menu"
       $(byText("Select Menu")).scrollTo().click(); // дописываем скролл перед кликом

        //Шаг 4 - выбираем что-то не красное в выпадающем списке
        $(byId("oldSelectMenu")).selectOption("Green");
        $(byId("oldSelectMenu")).shouldHave(text("Green"));

        //Шаг 5 - мультивыбор в выпадающем списке
        SelenideElement multiSelect = $x("//*[@id='selectMenuContainer']/div[7]/div/div/div");
        multiSelect.click(); // Открываем dropdown
            // Выбираем два значения
        $("#react-select-4-option-1").click();
        $("#react-select-4-option-2").click();
        multiSelect.click();
            // Проверяем, что значения отобразились как выбранные
        $x("//*[@id='selectMenuContainer']/div[7]/div/div/div/div[1]").shouldHave(text("Blue")).shouldHave(text("Black"));

    }
}
