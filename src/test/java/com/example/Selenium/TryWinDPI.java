package com.example.Selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.module.Configuration;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TryWinDPI {

    @Test
    void test() {

//        System.setProperty("sun.java2d.dpiaware", "false");
//        System.setProperty("sun.java2d.uiScale", "1.0");

//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\epashina\\Desktop\\Unikredit\\Shkola_AT_v2\\geckodriver-v0.35.0-win64\\geckodriver.exe");
//
//        FirefoxOptions options = new FirefoxOptions();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\epashina\\Desktop\\Unikredit\\Shkola_AT_v2\\chromedriver-win64\\chromedriver.exe");


        //пытаемся отключить настройки масштабирования винды 150% конкретно для тестов
       ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=1");
        options.addArguments("--high-dpi-support=1");
        options.addArguments("--window-size=1920,1080");
//        options.addArguments("--disable-gpu");
  //      options.addArguments("--disable-features=CalculateNativeWinOcclusion");
       // options.addArguments("--headless=new");
        //WebDriver driver = new FirefoxDriver(options);
        WebDriver driver = new ChromeDriver(options); // инициализируем наш драйвер

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object dpr = js.executeScript("return window.devicePixelRatio;");
        System.out.println(">>> devicePixelRatio = " + dpr); //должен вернуть = 1 (если 1,5 - то не работает игнор DPI)
        System.out.println(">>> screen: " + driver.manage().window().getSize());
        driver.quit();

    }
}