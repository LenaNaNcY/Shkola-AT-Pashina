package com.example.extensions.anno;

import com.example.extensions.SetUpBrowserExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtendWith(SetUpBrowserExtension.class)
public @interface SetUpBrowser {
    String url();
}