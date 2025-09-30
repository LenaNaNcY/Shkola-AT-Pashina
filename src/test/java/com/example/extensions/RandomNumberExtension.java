package com.example.extensions;

import com.example.extensions.anno.RandomNumber;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.support.AnnotationSupport;

public class RandomNumberExtension implements ParameterResolver, BeforeEachCallback {

    public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(RandomNumberExtension.class);

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        // Генерируем случайное число в диапазоне, если у метода еть аннотация @RandomNumber
        AnnotationSupport.findAnnotation(context.getRequiredTestMethod(), RandomNumber.class)
                .ifPresent(randomNumber -> {
                    int min = randomNumber.min();
                    int max = randomNumber.max();

                    int result = min + (int)(Math.random() * (max - min + 1));

                    context.getStore(NAMESPACE).put(context.getUniqueId(), result);
                });
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext context) throws ParameterResolutionException {
        // Активируем резолвер только для параметров с типом Integer
        return parameterContext.getParameter().getType().isAssignableFrom(Integer.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext context) throws ParameterResolutionException {
        // Задаем значение сгенерированного числа параметру теста
        return context.getStore(NAMESPACE).get(context.getUniqueId(), Integer.class);
    }
}