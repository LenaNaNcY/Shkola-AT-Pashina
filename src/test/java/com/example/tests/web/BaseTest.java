package com.example.tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeAll
    static void setUpAll() {
        // Настройка один раз перед всеми тестами
        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1440";
            //Закомментила предыдущую и добавила эту строку, тк хром открывался не во весь экран,
            // а чуть ниже и правее. Но с моим вариантом тоже не во весь экран, а меньше и левее.
            // Configuration.browserSize = "maximize"; // ← МАКСИМИЗИРОВАТЬ ОКНО
        Configuration.pageLoadTimeout = 20000;
            //добавила эту строку, тк тест падает из-за того, что таймаут превышает 4сек, как положено у селенида; но оказалось,
            // что проблема с долгой загрузкой не в этом
            //Configuration.timeout = 10000;
        //И вот именно добавление строки ниже вылечило тест, который всё время падал, тк вис, ибо по умолчанию этот параметра = "normal", а значит ждёт пока загрущится всё — DOM, стили, скрипты, рекламу.
        Configuration.pageLoadStrategy = "eager"; // ← КЛЮЧЕВОЙ ПАРАМЕТР! меняем стратегию загрузки, ждёт только DOM ready → страница интерактивна, даже если реклама не загрузилась
        System.out.println(">>> [BeforeAll] Браузер настроен глобально.");
    }

    @BeforeEach
    void setUpEach() {
        // Открытие главной страницы перед каждым тестом
        Selenide.open("https://demoqa.com/");
        System.out.println(">>> [BeforeEach] Открыта главная страница DemoQA.");
    }

    @AfterEach
    void tearDownEach() {
        // Закрытие браузера после каждого теста
        Selenide.closeWebDriver();
        System.out.println(">>> [AfterEach] Браузер закрыт.");
    }

    @AfterAll
    static void tearDownAll() {
        // Опционально: можно очистить кэш, отчеты и т.д.
        System.out.println(">>> [AfterAll] Все тесты завершены. Глобальная очистка.");
    }
}
