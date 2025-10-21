package com.example.Selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SeleniumDRAFT {

    @Test
    void test() { //чутка правее то, чего не было на слайде, но было в видео; ещё более право то, что я сомневаюсь, что нужно
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\.....\\win.chromedriver.exe");
//  это не оч надо, тк я не с хопа
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.setBinary("C:\\Users\\.....\\chrome.exe"); //указываем установочник для нашего браузера
//        WebDriver driver = new ChromeDriver(); // инициализируем наш драйвер, если бы указывали chromeOptions, то в скобках было бы оно
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\epashina\\Desktop\\Unikredit\\Shkola_AT_v2\\geckodriver-v0.35.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/"); // передача урла
        driver.manage().deleteAllCookies(); // удаление всех кук
        driver.manage().window().maximize(); // работа с

        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // неявное ожидание

        // явное ожидание (ожидался эл-т 2 мин, мы его не дождались)
//        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element-id")));

        // умное ожидание
//                Wait<WebDriverWait> wait = new FluentWait<>(driver);
//                    .withTimeout(Duration.ofSeconds(5))
//                    .pollingEvery(Duration.ofMillis(500))
//                    .ignoring(NoSuchElementException.class)
//              WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element-id")));


        //driver.navigate().refresh(); //рефреш страницы


        // тест различия close vs quit:
//                    driver.switchTo().newWindow(WindowType.TAB); // открываем новую вкладку
//                    driver.get("https://demoqa.com/");
//                    driver.close(); // метод close не закрывает наш браузер, только вкладку
//                        driver.quit(); // метод close закрывает всё

        WebElement elementsTab = driver.findElement(By.xpath("//h5[text()= 'Elements']"));
        elementsTab.click(); //кликаем по плашке с текстом Элементс

        WebElement checkBoxTab = driver.findElement(By.xpath("//span[contains(text(), 'Check')]"));
        Assertions.assertTrue(checkBoxTab.isEnabled(), "Карточка с названием CheckBox доступна");

        //проверяем, что плашка в правом меню называеися Радио Баттон
        WebElement radioBtnTab = driver.findElement(By.xpath("//span[starts-with( . , 'Radio']"));
        Assertions.assertEquals("Radio Button", radioBtnTab.getText(), "Неверное название карточки Radio Button");

        WebElement textBoxTab = driver.findElement(By.xpath("//span[text()='Text Box']"));
        textBoxTab.click(); //кликаем по плашке текстбокс

        WebElement fullNameInput = driver.findElement(By.cssSelector("input[id='userName']"));
        fullNameInput.sendKeys("Привет"); //пишем в ней какой-то текст

        WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit']"));
        submitBtn.click(); // жмём кнопку Сабмит

        WebElement output = driver.findElement(By.id("name"));
        Assertions.assertEquals("Name:Привет", output.getText(), "Название не соответствует введённому значению");
        // проверяем, что внизу вывелось

        driver.quit(); // метод закрывает всё
    }
}
