package hu.acsaifz.algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {

    Algorithms algorithms = new Algorithms();

    @Test
    void testCountMaximums() {
        List<Integer> numbers = List.of(1, 3, 4, 4, 2, 3, 4, 1);

        assertEquals(3, algorithms.countMaximums(numbers));
    }

    @Test
    void testWithNegativeNumbers() {
        List<Integer> numbers = List.of(-1, -3, -4, -4, -2, -3, -4, -1, -7, -3, -2, -2);

        assertEquals(2, algorithms.countMaximums(numbers));
    }

    @Test
    void testWithOneNumber() {
        List<Integer> numbers = List.of(8);

        assertEquals(1, algorithms.countMaximums(numbers));
    }

    @Test
    void testWithEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> algorithms.countMaximums(List.of()));
    }
}
