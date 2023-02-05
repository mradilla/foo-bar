package dev.mrad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionLvl2_1Test {
    @ParameterizedTest
    @CsvSource({
            "210022,3,3",
            "1211,10,1"
    })
    void solution(String n, int b, int expected) {
        Assertions.assertEquals(expected, SolutionLvl2_1.solution(n, b));
    }
}