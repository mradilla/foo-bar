package foo.bar.level_3;

public class Solution_1 {

    public static int solution(int start, int length) {
        int result = 0;
        int count = start;
        for (int i = length; i > 0; i--) {
            for (int j = 0; j < length; j++, count++) {
                if (j < i) {
                    result ^= count;
                }
            }
        }
        return result;
    }

}
