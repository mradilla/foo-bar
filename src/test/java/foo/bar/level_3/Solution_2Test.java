package foo.bar.level_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Solution_2Test {

    @ParameterizedTest
    @CsvSource({
            "1,0",
            "2,1",
            "3,2",
            "4,2",
            "5,3",
            "6,3",
            "7,4",
            "8,3",
            "9,4",
            "10,4",
            "11,5",
            "12,4",
            "13,5",
            "14,5",
            "15,5",
            "16,4",
            "18,5",
            "19,6",
            "20,5",
            "21,6",
            "22,6",
            "23,6",
            "24,5",
            "25,6",
            "26,6",
            "27,7",
            "28,6",
            "29,7",
            "30,6",
            "31,6",
            "63,7",
            "100,8",
            "120,8",
            "125,9",
            "1000,12",
            "1910,14",
            "1911,14",
            "123123,22",
            "12311312313123123123123123123131231231231233432531314235443576576572345123113123131231231231231231231312312312312334325313142354435765765723451231131231312312312312312312313123123123123343253131423544357657657234512311312313123123123123123123131231231231233432531314235443576576572345,1230"
    })
    void solution2(String x, int expected) {
        Assertions.assertEquals(expected, Solution_2.solution(x));
    }


}
