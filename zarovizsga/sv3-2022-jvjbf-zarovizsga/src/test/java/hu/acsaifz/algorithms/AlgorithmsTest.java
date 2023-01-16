package hu.acsaifz.algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {

    Algorithms algorithms = new Algorithms();

    @Test
    void testIsChainOfWordTrue() {
        List<String> words = List.of("apple", "earth", "hint", "temple");

        assertTrue(algorithms.isChainOfWords(words));
    }

    @Test
    void testIsChainOfWordFalse() {
        List<String> words = List.of("apple", "earth", "door", "temple");

        assertFalse(algorithms.isChainOfWords(words));
    }

    @Test
    void testIsChainOfWordWithCase() {
        List<String> words = List.of("apple", "Earth", "hint", "Temple");

        assertTrue(algorithms.isChainOfWords(words));
    }
}