package com.example.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.example.tests.ParameterizedTests.Direction.EAST;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedTests {

    @ValueSource(strings = {
            "Google",
            "Yandex"
    })
    @ParameterizedTest
    void searchTest(String testData) {
        assertEquals("Google", testData);
    }

    @CsvSource(value = {
            "alex, 30",
            "brian, 35",
            "charles, 40"
    })
    @ParameterizedTest
    void testWithCsvSource(String name, int age) {
        assertEquals("alex", name);

        assertEquals(30, age);
    }

    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    @ParameterizedTest
    void testWithCsvFileSource(String name, int age) {
        assertEquals("alex", name);

        assertEquals(30, age);
    }

    @MethodSource("methodSourceExampleTest")
    @ParameterizedTest
    void methodSourceExampleTest(String first, List<Integer> second) {
        System.out.println(first + " and list: " + second);
    }

    private static Stream<Arguments> methodSourceExampleTest() {
        return Stream.of(
                Arguments.of("first string", List.of(42, 13)),
                Arguments.of("second string", List.of(1, 2))
        );
    }

    @EnumSource(Direction.class)
    @ParameterizedTest
    void testWithEnumSource(Direction d) {
        assertEquals(EAST, d);
    }

    enum Direction {
        EAST, WEST, NORTH, SOUTH
    }
}