package com.example.extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(TimingExtension.class);

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        context.getStore(NAMESPACE).put(context.getUniqueId(), System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        long startTime = context.getStore(NAMESPACE).remove(context.getUniqueId(), long.class);

        long duration = System.currentTimeMillis() - startTime;

        System.out.printf("Тест '%s' выполнен за %d мс%n", context.getDisplayName(), duration);
    }
}