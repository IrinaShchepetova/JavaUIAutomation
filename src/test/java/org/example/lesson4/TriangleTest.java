package org.example.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.lesson4.Triangle.isTriangle;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    private static final Logger logger = LoggerFactory.getLogger("TriangleTest");

    @BeforeAll
    static void beforeAll() {
        logger.info("Метод выполняется один раз перед всеми методами класса");
    }

    @Test
    @DisplayName("Метод проверки решения функции площади треугльника")
    void givenTriangleWhenCallIsTriangleThenTrue() throws NumberIsNegative {
        double result = isTriangle(5, 6, 7);
        double actual = 14.696938456699069;
        assertEquals(result, actual);
    }

    @ParameterizedTest
    @DisplayName("Проверка на нулевое значение")
    @ValueSource(doubles = {7, 8, 9})
    void assertNotNull(double numbers) {
        Assertions.assertNotNull(numbers);
    }

    @ParameterizedTest
    @DisplayName("Проверка на отрицательное значение")
    @CsvSource({"1","4","5"})
    void assertNumberIsNegative(double numbers) {
        assertThat(numbers).isLessThan(10).isGreaterThan(0);
    }

    @Test
    @DisplayName("Проверка на соответствие чисел")
    void groupAssertions() {
        double[] numbers = {2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 2),
                () -> assertEquals(numbers[1], 3),
                () -> assertEquals(numbers[2], 4)
        );
    }
    @Test
    @DisplayName("Проверка исключения")
    void triangleNegativeTestThrowException() {
        Assertions.assertThrows(NumberIsNegative.class, () -> isTriangle(-2, 2, 2));
    }
}







