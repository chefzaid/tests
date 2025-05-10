package com.exercise;

import java.util.*;

public class OddNumberCounter {
    public static int countOdds(List<Integer> numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println("Odd numbers count: " + countOdds(nums));
    }
}
