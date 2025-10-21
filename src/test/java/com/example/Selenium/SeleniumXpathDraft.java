package com.example.Selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SeleniumXpathDraft {

    @Test
    void test () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\epashina\\Desktop\\Unikredit\\Shkola_AT_v2\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // инициализируем наш драйвер

        driver.manage().deleteAllCookies(); // удаление всех кук
        driver.manage().window().maximize(); // окно во весь экран

        driver.get("https://demoqa.com/"); // передача урла
        // неявное ожидание
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        //асболютный путь /html/body/div
        //относительный путь //div/header  //div//a

        //last() //div[@class= 'category-cards']/div[last()]
        //starts-with(), name() //*[starts-with(name(), 'head']

        //ancestor::    //h5[text() = 'Elements']/ancestor::div

        //fololgwing-sibling::  //div[@class='category-cards']//following-sibling::*

//        //NoSuchElementException
//        WebElement element = driver.findElement(By.xpath("//div[@class = 'card mt-4 top-cart']")); - делаем намеренную опечатку, вместо card  пишем t
//        element.click();

//        //NoSuchWindowException
//        driver.switchTo().newWindow(WindowType.TAB); // открываем новое окно
//        driver.get("https://demoqa.com/");
//        driver.close(); // закрыли окно
//        WebElement elementsTab = driver.findElement(By.xpath("//h5[text()= 'Elements']")); // и пытаемся в закрытом окне найти элемент
//        elementsTab.click(); // тест падает

//        List<WebElement> elements = driver.findElements(By.xpath("//div[@class = 'card mt-4 top-card'"));
//        Assertions.assertEquals(6, elements.size());


        driver.quit(); // метод quit закрывает весь браузер

    }
}
