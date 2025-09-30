package com.example.tests;

import com.example.dto.User;
import com.example.extensions.anno.UserAnno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTests {


    @Test
    @UserAnno(username = "Bob", password = "12345")
    void createUserTest(User user) {
        assertNotNull(user.id(), "ID not null");
    }

}