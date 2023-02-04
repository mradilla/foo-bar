package dev.mrad;
// The cake is not a lie!
// 02/2023
public class SolutionLvl1 {
    public static int solution(String x) {
        int minSequenceLength = Math.toIntExact(x.chars().distinct().count());
        if (x.length() == minSequenceLength) {
            return 1;
        }
        int inputLength = x.length();
        for (int i = minSequenceLength; i < inputLength; i++) {
            String sequence = x.substring(0, i);
            int sequenceCount = 1;
            for (int j = i; j < inputLength; j += i) {
                String group = x.substring(j, Math.min(inputLength, j + i));
                if (sequence.equals(group)) {
                    sequenceCount++;
                } else {
                    break;
                }
            }
            if (sequenceCount * sequence.length() == inputLength) {
                return sequenceCount;
            }
        }
        return 1;
    }
}