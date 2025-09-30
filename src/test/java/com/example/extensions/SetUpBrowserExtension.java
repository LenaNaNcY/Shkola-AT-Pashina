package com.example.extensions;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SetUpBrowserExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1440";
        Configuration.pageLoadTimeout = 20000;
        System.out.println(">>> [BeforeAll] Браузер настроен глобально.");
    }
}