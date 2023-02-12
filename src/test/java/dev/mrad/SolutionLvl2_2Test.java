package dev.mrad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SolutionLvl2_2Test {

    @ParameterizedTest
    @CsvSource({
            "10,10,0",
            "0,63,6",
            "0,61,4",
            "63,0,6",
            "19,18,3",
            "0,27,2",
            "7,8,4",
            "52,43,2",
            "63,55,3",
            "56,58,2",
            "19,36,1",
            "0,1,3",
            "0,27,2",
            "0,56,5",
            "56,0,5",
            "24,0,3"
    })
    void solution(int src, int dest, int expected) {
        Assertions.assertEquals(expected, SolutionLvl2_2.solution(src, dest));
    }

}
