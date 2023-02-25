package foo.bar.level_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static foo.bar.level_3.Solution_3.Fraction.ONE;
import static foo.bar.level_3.Solution_3.Fraction.ZERO;

public class Solution_3 {
    public static int[] solution(int[][] m) {

        Fraction[][] input = toFractionMatrix(m);
        LinkedList<Integer> absStates = new LinkedList<>();
        LinkedList<Integer> nonAbsStates = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            Fraction[] row = input[i];
            double count = 0;
            for (Fraction v : row) {
                count += v.asDouble();
            }
            if (count == 0) {
                absStates.add(i);
            } else {
                nonAbsStates.add(i);
            }
            for (int j = 0; j < row.length; j++) {
                if (count > 0) {
                    row[j] = new Fraction(row[j].num, (int) count);
                } else if (j == i) {
                    row[j] = ONE;
                }
            }
        }
        Fraction[][] matrixB = getSubmatrix(input, nonAbsStates.peekFirst(), nonAbsStates.peekLast(),
                nonAbsStates.peekFirst(), nonAbsStates.peekLast());
        Fraction[][] matrixA = getSubmatrix(input, nonAbsStates.peekFirst(), nonAbsStates.peekLast(),
                absStates.peekFirst(), absStates.peekLast());

        Fraction[][] identityMatrix = createIdentityMatrix(nonAbsStates.size());
        Fraction[][] subs = subtractMatrices(identityMatrix, matrixB);

        Fraction[][] fundamentalMatrix = inverseMatrix(subs);

        Fraction[][] solutionMatrix = multiplyMatrices(fundamentalMatrix, matrixA);

        return getSolutionArray(solutionMatrix[0]);
    }

    private static int[] getSolutionArray(Fraction[] fractions) {
        List<Integer> nums = new ArrayList<>();
        for (Fraction f : fractions) {
            int n = f.denom;
            if (n > 0) {
                nums.add(n);
            }
        }
        int lcm = Fraction.lcm(nums);
        int[] result = new int[fractions.length + 1];
        for (int i = 0; i < fractions.length; i++) {
            Fraction fraction = fractions[i];
            if (fraction.num == 0)
                result[i] = 0;
            else
                result[i] = lcm / fraction.denom * fraction.num;
        }
        result[fractions.length] = lcm;
        return result;

    }

    public static Fraction[][] inverseMatrix(Fraction[][] A) {
        int n = A.length;
        Fraction[][] B = new Fraction[n][n];
        Fraction[][] C = new Fraction[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = A[i][j];
                if (i == j) {
                    C[i][j] = ONE;
                } else {
                    C[i][j] = ZERO;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            Fraction det = B[k][k];
            for (int j = 0; j < n; j++) {
                B[k][j] = B[k][j].divide(det);
                C[k][j] = C[k][j].divide(det);
            }
            for (int i = 0; i < n; i++) {
                if (i != k) {
                    Fraction temp = B[i][k];
                    for (int j = 0; j < n; j++) {
                        B[i][j] = B[i][j].subtract(B[k][j].multiply(temp));
                        C[i][j] = C[i][j].subtract(C[k][j].multiply(temp));
                    }
                }
            }
        }

        return C;
    }

    public static Fraction[][] multiplyMatrices(Fraction[][] A, Fraction[][] B) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;
        Fraction[][] C = new Fraction[m][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                C[i][j] = ZERO;
                for (int k = 0; k < n; k++) {
                    C[i][j] = C[i][j].add(A[i][k].multiply(B[k][j]));
                }
            }
        }

        return C;
    }

    public static Fraction[][] subtractMatrices(Fraction[][] A, Fraction[][] B) {
        int nRows = A.length;
        int nCols = A[0].length;
        Fraction[][] C = new Fraction[nRows][nCols];
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                C[i][j] = A[i][j].subtract(B[i][j]);
            }
        }
        return C;
    }

    public static Fraction[][] createIdentityMatrix(int n) {
        Fraction[][] matrix = new Fraction[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (i == j) ? ONE : ZERO;
            }
        }
        return matrix;
    }

    public static Fraction[][] getSubmatrix(Fraction[][] matrix, int startRow, int endRow, int startCol, int endCol) {
        int numRows = endRow - startRow + 1;
        int numCols = endCol - startCol + 1;
        Fraction[][] submatrix = new Fraction[numRows][numCols];

        for (int i = startRow; i <= endRow; i++) {
            if (endCol + 1 - startCol >= 0)
                System.arraycopy(matrix[i], startCol, submatrix[i - startRow], 0, endCol + 1 - startCol);
        }

        return submatrix;
    }

    private static Fraction[][] toFractionMatrix(int[][] intArray) {
        Fraction[][] array = new Fraction[intArray.length][intArray[0].length];
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[0].length; j++) {
                array[i][j] = new Fraction(intArray[i][j]);
            }
        }
        return array;
    }

    public static class Fraction {

        public static final Fraction ZERO = new Fraction(0, 1);
        public static final Fraction ONE = new Fraction(1, 1);

        private int num, denom;

        public Fraction(double d) {
            String s = String.valueOf(d);
            int digitsDec = s.length() - 1 - s.indexOf('.');
            int denom = 1;
            for (int i = 0; i < digitsDec; i++) {
                d *= 10;
                denom *= 10;
            }
            this.denom = denom;
            this.num = (int) Math.round(d);
            simplify();
        }

        private void simplify() {
            int gcd = gcd(num, denom);
            num /= gcd;
            denom /= gcd;
        }

        public Fraction(int num, int denom) {
            this.num = num;
            this.denom = denom;
            simplify();
        }

        public static int gcd(int num, int denom) {
            return denom == 0 ? num : gcd(denom, num % denom);
        }

        public double asDouble() {
            return (double) num / denom;
        }

        public Fraction multiply(Fraction that) {
            int num = this.num * that.num;
            int denom = this.denom * that.denom;
            return new Fraction(num, denom);
        }

        public Fraction subtract(Fraction that) {
            int commonDenominator = this.denom * that.denom;
            int numerator1 = this.num * that.denom;
            int numerator2 = that.num * this.denom;
            int num = numerator1 - numerator2;
            return new Fraction(num, commonDenominator);
        }

        public Fraction add(Fraction that) {
            int commonDenominator = this.denom * that.denom;
            int numerator1 = this.num * that.denom;
            int numerator2 = that.num * this.denom;
            int num = numerator1 + numerator2;
            return new Fraction(num, commonDenominator);
        }

        public Fraction divide(Fraction that) {
            int num = this.num * that.denom;
            int denom = that.num * this.denom;
            return new Fraction(num, denom);
        }

        public static int lcm(List<Integer> numbers) {
            int lcm = numbers.get(0);
            for (int i = 1; i < numbers.size(); i++) {
                int num = numbers.get(i);
                lcm = (lcm * num) / gcd(lcm, num);
            }
            return lcm;
        }

    }

}