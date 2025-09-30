package com.example.extensions.anno;

import com.example.extensions.CreateUserExtension;
import com.example.extensions.UserResolverExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtendWith({CreateUserExtension.class, UserResolverExtension.class})
public @interface UserAnno {
    String username();
    String password();
}