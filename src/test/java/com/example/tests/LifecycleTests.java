package com.example.tests;

import org.junit.jupiter.api.*;

public class LifecycleTests {

    @BeforeAll
    static void initAll() {
        System.out.println("@BeforeAll - один раз перед всеми тестами \n");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - перед каждым тестом \n");
    }

    @Test
    void test1() {
        System.out.println("Test 1 выполняется \n");
    }

    @Test
    void test2() {
        System.out.println("Test 2 выполняется \n");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - после каждого теста \n");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll - один раз после всех тестов");
    }
}