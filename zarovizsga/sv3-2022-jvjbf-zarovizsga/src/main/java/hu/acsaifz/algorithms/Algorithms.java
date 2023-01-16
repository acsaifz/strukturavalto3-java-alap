package hu.acsaifz.algorithms;

import java.util.List;

public class Algorithms {

    public boolean isChainOfWords(List<String> words) {

        for (int i = 1;  i < words.size(); i++){
            String beginWord = words.get(i - 1).toLowerCase();
            String actualWord = words.get(i).toLowerCase();

            if (actualWord.charAt(0) != beginWord.charAt(beginWord.length() - 1)){
                return false;
            }
        }

        return true;
    }
}
