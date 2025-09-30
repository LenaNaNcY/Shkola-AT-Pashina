package com.example.tests;

import com.example.extensions.ExceptionHandlerExtension;
import com.example.extensions.RandomNumberExtension;
import com.example.extensions.TimingExtension;
import com.example.extensions.anno.RandomNumber;
import com.example.extensions.exeptions.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TimingExtension.class)
public class ExtensionTests {

    @Test
    void firstTest() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test
    void secondTest() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test
    void thirdTest() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test
    @RandomNumber(min = 10, max = 20)
    @ExtendWith(RandomNumberExtension.class)
    void randomNumberTest(Integer number) {
        System.out.println(number);

        assertTrue(number >= 10 && number <= 20, "Число " + number + " вне диапазона 10-20");
    }

    @Test
    @ExtendWith(ExceptionHandlerExtension.class)
    void testExpectedException() {
        throw new BusinessException("Ожидаемая бизнес-ошибка");
        // Исключения будет перехвачено и обработано
    }

    @Test
    void testWithoutExtension() {
        throw new BusinessException("Ожидаемая бизнес-ошибка");
        // Исключения НЕ будет перехвачено и обработано
    }

    @Test
    @ExtendWith(ExceptionHandlerExtension.class)
    void testUnexpectedException() {
        throw new RuntimeException("Критическая ошибка");
        // Исключения НЕ будет обработано и провалит тест
    }
}