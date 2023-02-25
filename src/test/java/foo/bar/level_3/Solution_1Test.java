package foo.bar.level_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Solution_1Test {

    @ParameterizedTest
    @CsvSource({
            "0,3,2",
            "17,4,14"
    })
    void solution(int start, int length, int expected) {
        Assertions.assertEquals(expected, Solution_1.solution(start, length));
    }

}
