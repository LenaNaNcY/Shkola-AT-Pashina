package com.example.extensions;

import com.example.extensions.exeptions.BusinessException;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class ExceptionHandlerExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {

        // Обрабатываем только определенные типы исключений
        if (throwable instanceof BusinessException) {
            System.err.println("Поймано BusinessException: " + throwable.getMessage());
            // Можно продолжить выполнение (игнорируем исключение)
            return;
        }

        // Для всех других исключений - стандартная обработка
        throw throwable;
    }
}