package hu.acsaifz.algorithms;

import java.util.List;

public class Algorithms {
    public int countMaximums(List<Integer> numbers) {
        int max = numbers
                .stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List can not be empty."));

        return numbers
                .stream()
                .filter(n -> n == max)
                .mapToInt(n -> 1).sum(); //szerintem ez a megoldás szebb mint a count() és castolás int-re, a count() is ugyanezt csinálja csak mapToLong()-al
    }
}
