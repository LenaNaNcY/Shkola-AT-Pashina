package Lection11_12Cucumber.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

public class CucumberStepdefs {

    @Дано("^открыт сайт \"([^\"]*)\"$") //regExp - не связывалось с шагом из фича, тк пропустила символ $. Важно: RegExp всегда должно начинаться и заканчиваться крышечкой и долларом
    public void открытСайт(String url) {
        open(url);
        System.out.println(">>> Открыта главная страница DemoQA.");
    }

    @Тогда("на странице {int} элементов")
    public void наСтраницеЭлементов(int sum) {
        ElementsCollection menuTabs = $$x("//div[@class='card mt-4 top-card']"); //ищем коллекцию из 6ти элементов
        menuTabs.shouldHave(size(sum));
    }
    @Когда("^совершен клик по меню \"([^\"]*)\"$")
    public void совершенКликПоМеню(String menuName) {
        $x(String.format("//h5[text()='%s']", menuName)).click(); //тип вместо текста в xPath подставляем передаваемый параметр из фича-файла
        //    $(byText(menuName)).click();
    }

    @Тогда("открываются варианты {string}, {string}, {string}, {string}, {string}")
    public void открываютсяВарианты(String arg0, String arg1, String arg2, String arg3, String arg4) {
        ElementsCollection subMenuItems = $$(byXpath("//div[@class='element-list collapse show']//span")); // получаем коллекцию подпунктов меню
        subMenuItems.shouldHave(texts("Browser Windows", "Alerts", "Frames", "Nested Frames", "Modal Dialogs"));
    }


    @Тогда("на странице <sum> элементов")
    public void наСтраницеSumЭлементов() {
    }

    @Тогда("открываются варианты <arg{int}>, <arg{int}>, <arg{int}>, <arg{int}>, <arg{int}>")
    public void открываютсяВариантыArgArgArgArgArg(int arg0, int arg1, int arg2, int arg3, int arg4) {
    }


    @Когда("в списке {string} выбрираем значение {string}")
    public void вСпискеВыбрираемЗначение(String arg0, String color) {
        $(byId("oldSelectMenu")).selectOption(color);
    }

    @Тогда("в поле {string} выбрано значение {string}")
    public void вПолеВыбраноЗначение(String arg0, String text) {
        $(byId("oldSelectMenu")).shouldHave(text(text));
    }

    @И("закрыт браузер")
    public void закрытБраузер() {
        closeWebDriver();
        System.out.println(">>> [AfterEach] Браузер закрыт.");
    }


    @Когда("совершен клик по пункту {string}")
    public void совершенКликПоПункту(String punktName) {
        $(byText(punktName)).scrollTo().click(); //клик по пункту "Nested Frames"
    }

    @Тогда("там есть текст {string}")
    public void тамЕстьТекст(String text) {
        $(By.id("framesWrapper")).shouldHave(text(text));
    }

    @Когда("переходим во фрейм {string}")
    public void переходимВоФрейм(String arg0) {
        switchTo().frame($(byId("frame1"))); //переходим сначала в родительский фрейм
        SelenideElement childFrame = $(byTagName("iframe")); //находим дочерний по тэгу, тк id там нет и ваще кроме текста и тегов ничего нет
        switchTo().frame(childFrame); //проваливаемся в дочерний
    }

    @Тогда("во фрейме есть текст {string}")
    public void воФреймеЕстьТекст(String text) {
        $(byTagName("body")).shouldHave(text(text));
    }

    @Когда("возвращаемся в родительский фрейм")
    public void возвращаемсяВРодительскийФрейм() {
        switchTo().parentFrame(); // возврат на уровень выше — в parent iframe
    }

    @Когда("возвращаемся в основной документ")
    public void возвращаемсяВОсновнойДокумент() {
        switchTo().defaultContent();
    }

    @Тогда("форма содержит текст {string}")
    public void формаСодержитТекст(String text) {
        SelenideElement pageFrames = $(byId("framesWrapper"));
        pageFrames.shouldHave(text(text)); //проверяем содержимый текст
    }

    @Тогда("на форме имеется кнопка с текстом {string}")
    public void наФормеИмеетсяКнопкаСТекстом(String text) {
        $(byCssSelector("#startStopButton")).shouldHave(text(text));
    }

    @Когда("совершен клик по кнопке {string}")
    public void совершенКликПоКнопке(String arg0) {
        $(byCssSelector("#startStopButton")).click();
    }

    @Тогда("на кнопке есть текст {string}")
    public void наКнопкеЕстьТекст(String text) {
        $("#startStopButton").shouldHave(text(text));
    }

    @Когда("прогресс-бар достигает числа {int}")
    public void прогрессБарДостигаетЧисла(int num) {
        $x("//*[@id='progressBar']/div").shouldHave(Condition.attribute("aria-valuenow", String.valueOf(num)));// Ждём, пока прогресс-бар станет "30%"
        // Как только он стал 30% — кликаем по кнопке "Stop"
        $(byCssSelector("#startStopButton")).click();
    }


    @Когда("в выпадающем сприске выбираем {int} значения")
    public void вВыпадающемСприскеВыбираемЗначения(int arg0) {
        SelenideElement multiSelect = $x("//*[@id='selectMenuContainer']/div[7]/div/div/div");
        multiSelect.click(); // Открываем dropdown
        // Выбираем два значения
        $("#react-select-4-option-1").click();
        $("#react-select-4-option-2").click();
        multiSelect.click();
    }

    @Тогда("в списке выбраны требуемые значения")
    public void вСпискеВыбраныТребуемыеЗначения() {
        $x("//*[@id='selectMenuContainer']/div[7]/div/div/div/div[1]").shouldHave(text("Blue")).shouldHave(text("Black"));

    }
}
