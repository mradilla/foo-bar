package dev.mrad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class SolutionLvl1Test {

    @ParameterizedTest
    @CsvSource({
           "abcabcabcabc,4",
            "abccbaabccba,2",
            "abcabcabcabc,4",
            "abccbaabccba,2",
            "abdccbadabccbaz,1",
            "abcdefghi,1",
            "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc, 56",
            "1212, 2",
            "abcde, 1",
            "bcdefabcdefa,2",
            "bcdefabcdefag,1",
            "abcdababcdab,2",
            "abcdeabcd,1",
            "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabtcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc,1",
            "jabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabtcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc,1",
            "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcg, 1",
            "vaaavaaavaaavaaa,4",
            "vaaavaaavaaavaaaa,1",
            "aaaaaaa,7",
            "abba,1"
    })

    void solution(String input, int expected) {
        Assertions.assertEquals(expected, SolutionLvl1.solution(input));
    }
}