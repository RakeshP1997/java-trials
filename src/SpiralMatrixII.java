import java.util.Arrays;

/**Problem statement
 * https://leetcode.com/problems/spiral-matrix-ii/
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 */
public class SpiralMatrixII {
    static class Solution {
        public int[][] generateMatrix(int n) {
            int m = n;
            int[][] a = new int[n][n];
            int i, k = 0, l = 0, count = 1;
            while (k < m && l < n) {
                // Print the first row from the remaining rows
                for (i = l; i < n; ++i) {
                    a[k][i] = count++;
                }
                k++;

                // Print the last column from the remaining
                // columns
                for (i = k; i < m; ++i) {
                    a[i][n - 1] = count++;
                }
                n--;

                // Print the last row from the remaining rows */
                if (k < m) {
                    for (i = n - 1; i >= l; --i) {
                        a[m - 1][i] = count++;
                    }
                    m--;
                }

                // Print the first column from the remaining
                // columns */
                if (l < n) {
                    for (i = m - 1; i >= k; --i) {
                        a[i][l] = count++;
                    }
                    l++;
                }
            }
            return a;
        }
    }

    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int ip = 3;
        int[][] output = new Solution().generateMatrix(ip);
        System.out.println("Output: ");
        for (int[] op :
                output) {
            System.out.print(" {");
            Arrays.stream(op).forEach(num -> System.out.print(num + " "));
            System.out.println("} ");
        }
        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
