package dev.mrad.level_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_1 {

    public static int solution(String n, int b) {
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        int cycleCount = 0;
        Integer indexLastSeen;
        do {
            indexLastSeen = map.get(n);
            if (indexLastSeen != null) {
                cycleCount = i - indexLastSeen;
            } else {
                map.put(n, i++);
                n = getNext(n, b);
            }
        } while (indexLastSeen == null);

        return cycleCount;
    }

    public static String getNext(String n, int b) {
        List<String> digits = Arrays.asList(n.split(""));
        Collections.sort(digits);
        String yStr = String.join("", digits);
        Collections.reverse(digits);
        String xStr = String.join("", digits);
        int x = Integer.parseInt(xStr, b);
        int y = Integer.parseInt(yStr, b);
        String zStr = Integer.toString(x - y, b);
        return String.format("%0" + n.length() + "d", Integer.valueOf(zStr));
    }

}
