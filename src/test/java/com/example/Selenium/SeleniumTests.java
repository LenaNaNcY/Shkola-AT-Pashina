package com.example.Selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.module.Configuration;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SeleniumTests {

    @Test
    void test() {

      System.setProperty("webdriver.chrome.driver", "C:\\Users\\epashina\\Desktop\\Unikredit\\Shkola_AT_v2\\chromedriver-win64\\chromedriver.exe");

        //пытаемся отключить настройки масштабирования винды 150% конкретно для тестов
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=1");
        options.addArguments("--high-dpi-support=1");
        options.addArguments("--window-size=1920,1080");

      WebDriver driver = new ChromeDriver(options); // инициализируем наш драйвер

            driver.manage().deleteAllCookies(); // удаление всех кук
            driver.manage().window().maximize(); // работа с окном

        driver.get("https://demoqa.com/"); // передача урла
        // неявное ожидание
           // driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); - это зачёркивается, гугл говорит, оно устарело => добавила внизу современную форму
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        //проверяем, что вкладка Elements присутствует, и кликаем по ней
        WebElement elementsTab = driver.findElement(By.xpath("//h5[text()='Elements']"));
        // без строчки с прокруткой тест не работает и падает, ибо экран маленький, и текст эл-та не видит
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsTab);
        elementsTab.click(); //кликаем по плашке с текстом Элементс

        //проверяем, что вкладка Text Box присутствует, и кликаем по ней
        WebElement textBoxTab = driver.findElement(By.xpath("//span[text()='Text Box']"));
        textBoxTab.click();

        //Заполняем форму
        WebElement fullNameInput = driver.findElement(By.cssSelector("input[id='userName']"));
        fullNameInput.sendKeys("Елена"); //поле Name
        WebElement emailInput = driver.findElement(By.cssSelector("input[id='userEmail']"));
        emailInput.sendKeys("Elena@demoqa.com"); //поле Email
        WebElement currentAddressTextarea = driver.findElement(By.cssSelector("textarea[id='currentAddress']"));
        currentAddressTextarea.sendKeys("г Александров, СНТ Искож-1"); //поле Current Address
        WebElement permanentAddressTextarea = driver.findElement(By.cssSelector("textarea[id='permanentAddress']"));
        permanentAddressTextarea.sendKeys("г Москва, ленинский пр-т"); //поле Permanent Address


        WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        submitBtn.click(); // жмём кнопку Сабмит

        WebElement output = driver.findElement(By.id("name"));
        Assertions.assertEquals("Name:Елена", output.getText(), "Название не соответствует введённому значению");
        WebElement output2 = driver.findElement(By.id("email"));
        Assertions.assertEquals("Email:Elena@demoqa.com", output2.getText(), "Название не соответствует введённому значению");
        WebElement output3 = driver.findElement(By.cssSelector("p[id='currentAddress']"));
        Assertions.assertEquals("Current Address :г Александров, СНТ Искож-1", output3.getText(), "Название не соответствует введённому значению");
        WebElement output4 = driver.findElement(By.cssSelector("p[id='permanentAddress']"));
        Assertions.assertEquals("Permananet Address :г Москва, ленинский пр-т", output4.getText(), "Название не соответствует введённому значению");
        // проверяем, что внизу вывелось

        driver.quit(); // метод close закрывает всё


    }
}
