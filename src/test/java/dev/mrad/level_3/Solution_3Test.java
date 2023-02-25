package dev.mrad.level_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Solution_3Test {
    @Test
    void test1() {
        int[][] input = {
                {0, 2, 1, 0, 0},
                {0, 0, 0, 3, 4},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        int [] expected = {7, 6, 8, 21};
        assertArrayEquals(expected, Solution_3.solution(input));
    }
    @Test
    void test2() {
        int[][] input = {
                {0, 1, 0, 0, 0, 1},
                {4, 0, 0, 3, 2, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        int [] expected = {0, 3, 2, 9, 14};
        assertArrayEquals(expected, Solution_3.solution(input));
    }
}

