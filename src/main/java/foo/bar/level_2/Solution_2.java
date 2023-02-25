package foo.bar.level_2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static java.lang.Math.abs;
// Don't Get Volunteered!

public class Solution_2 {

    public static final int BOARD_LENGTH = 8;
    public static final int KNIGHT_MOVES = 3;

    public static int solution(int src, int dest) {
        Coord srcCoord = Coord.of(src);
        Coord destCoord = Coord.of(dest);
        LinkedList<Coord> toVisit = new LinkedList<>();
        Set<Coord> visited = new HashSet<>();

        visited.add(srcCoord);
        toVisit.add(srcCoord);

        while (!toVisit.isEmpty()) {
            Coord currentCoord = toVisit.poll();

            if (currentCoord.equals(destCoord)) {
                return currentCoord.distance;
            }

            for (int i = KNIGHT_MOVES * -1 + 1; i < KNIGHT_MOVES; i++) {
                for (int j = KNIGHT_MOVES * -1 + 1; j < KNIGHT_MOVES; j++) {
                    boolean isValidMove = (abs(i) + abs(j)) % KNIGHT_MOVES == 0;
                    if (isValidMove) {
                        int newX = currentCoord.x + i;
                        int newY = currentCoord.y + j;
                        Coord possibleMove = new Coord(newX, newY, currentCoord.distance + 1);
                        if (isValidCoord(possibleMove) && !visited.contains(possibleMove)) {
                            visited.add(possibleMove);
                            toVisit.add(possibleMove);
                        }
                    }
                }
            }
        }
        return -1;
    }


    public static boolean isValidCoord(Coord coord) {
        return isValidPosition(coord.x) && isValidPosition(coord.y);
    }

    private static boolean isValidPosition(int n) {
        return n >= 0 && n < BOARD_LENGTH;
    }

    static class Coord {
        int x;
        int y;
        int distance;

        public Coord(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public static Coord of(int n) {
            int row = n / BOARD_LENGTH;
            int column = n - (row * BOARD_LENGTH);
            return new Coord(row, column, 0);
        }

        @Override
        public boolean equals(Object o) {
            Coord coord = (Coord) o;
            if (x != coord.x) return false;
            return y == coord.y;
        }

    }

}