import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {
    Calculator calculator;
    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Trivial test.")
    void trivialTest() {
        assertTrue(true);
    }
    @Test
    @DisplayName("Add positive integers.")
    void addPositiveIntegers() {
        assertEquals(21,
                calculator.add(10,11),
                "Added two positive integers.");
    }

    @Test
    @DisplayName("Add a positive and a negative integer.")
    void addNegativeAndPositiveIntegers() {
        assertEquals(-1,
                calculator.add(1,-2),
                "Added a positive and a negative integer.");
    }

    @Test
    @DisplayName("Overflow integer.")
    void addIntegerOverflow() {
        assertEquals(-2147483648,
                calculator.add(2147483647, 1),
                "Added one to overflow the highest integer.");
    }

    @Test
    @DisplayName("Add positive bytes.")
    void addPositiveBytes() {
        assertEquals(0b010, calculator.add(0b001, 0b001),
                "Added two positive bytes.");
    }

    @Test
    @DisplayName("Add positive floats.")
    void addPositiveFloats() {
        assertEquals(0.1f, calculator.add(0.0f, 0.1f),
                "Added two positive floats.");
    }

    @Test
    @DisplayName("Add positive doubles.")
    void addPositiveDoubles() {
        assertEquals(0.1, calculator.add(0.0, 0.1),
                "Added two positive doubles.");
    }

    @Test
    @DisplayName("Overflow positive longs.")
    void addPositiveLongs() {
        assertEquals(-9223372036854775808L, calculator.add(9223372036854775807L, 1L),
                "Overflowed a long.");
    }
}