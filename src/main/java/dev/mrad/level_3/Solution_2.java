package dev.mrad.level_3;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class Solution_2 {

    public static int solution(String x) {
        BigInteger n = new BigInteger(x);
        BigInteger THREE = BigInteger.valueOf(3);
        BigInteger FOUR = BigInteger.valueOf(4);
        int count = 0;
        while (n.bitLength() > 1) {
            if (!n.testBit(0)) {
                n = n.shiftRight(1);
            } else {
                BigInteger plusOne = n.add(ONE);
                if (n.compareTo(THREE) > 0 && plusOne.mod(FOUR).equals(ZERO)) {
                    n = plusOne;
                } else {
                    n = n.subtract(ONE);
                }
            }
            count++;
        }
        return count;
    }

}
