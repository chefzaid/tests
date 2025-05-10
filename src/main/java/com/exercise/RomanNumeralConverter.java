package com.exercise;

import java.util.Map;

public class RomanNumeralConverter {

    private static final Map<Character, Integer> ROMAN_TO_INT = Map.of(
        'I', 1, 
        'V', 5, 
        'X', 10, 
        'L', 50,
        'C', 100, 
        'D', 500, 
        'M', 1000
    );
    
    public static int romanToInt(String s) {
        int total = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = ROMAN_TO_INT.get(s.charAt(i));
            total += (curr < prev) ? -curr : curr;
            prev = curr;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXC")); // Output: 1990
    }
}
