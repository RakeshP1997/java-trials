import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**Problem statement
 * https://leetcode.com/problems/set-matrix-zeroes/
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 */
public class SetMatrixZeroes {
    static class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = matrix[i][j];
                }
            }
            int k = 0, l = 0;
            while (k < m) {
                if (matrix[k][l] == 0) {
                    int t = 0;
                    while (t < n) {
                        temp[k][t++] = 0;
                    }
                    t = 0;
                    while (t < m) {
                        temp[t++][l] = 0;
                    }
                }
                if (l >= n - 1) {
                    k++;
                    l = 0;
                } else {
                    l++;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = temp[i][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int[][] ip = {{1,1,1},{1,0,1},{1,1,1}};
//        int[][] ip = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        new Solution().setZeroes(ip);
        System.out.print("Output: ");
        for (int[] op :
                ip) {
            System.out.print(" {");
            Arrays.stream(op).forEach(num -> System.out.print(num + " "));
            System.out.print("} ");
        }
        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
