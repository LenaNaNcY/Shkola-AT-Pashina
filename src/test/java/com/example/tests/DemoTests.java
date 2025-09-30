package com.example.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("Демо тесты")
public class DemoTests {

    @Test
    void testPassed() {
        assertEquals(2 + 2, 4); // Условие верно -> тест пройден
    }

    @Test
    void testFailed() {
        assertEquals(5, 2 + 2); // Ожидается 5, но получается 4 -> AssertionFailedError
    }

    @Test
    void testBroken() {
        throw new RuntimeException("Что-то сломалось!"); // Не ассерт, а другое исключение
    }

    @Test
    void testAborted() {
        assumeTrue(false, "Тест пропущен, так как условие не выполнено"); // Тест не запускается
        System.out.println("Этот код не выполнится");
    }

    @Test
    @Disabled("Тест отключен для демонстрации")
    void testDisabled() {
        fail("Этот тест не должен выполняться!");
    }
}