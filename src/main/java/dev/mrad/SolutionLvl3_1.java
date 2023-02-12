package dev.mrad;

public class SolutionLvl3_1 {

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
