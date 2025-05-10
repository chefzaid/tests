package com.exercise;

import java.util.*;

public class LetterCounter {
    public static Map<Character, Integer> countLetters(String input) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }
        }
        return countMap;
    }

    public static void main(String[] args) {
        String input = "HelloWorld";
        Map<Character, Integer> result = countLetters(input);
        result.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
