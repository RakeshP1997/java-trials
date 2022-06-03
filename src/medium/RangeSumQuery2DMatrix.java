package medium;

/** Problem statement: 304. Range Sum Query 2D - Immutable
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 *
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 *
 * Calculate the sum of the elements of matrix inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * Implement the NumMatrix class:
 *
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 */
public class RangeSumQuery2DMatrix {
    static class NumMatrix {
        private int[][] sum;
        private void prefixSum(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                this.sum[i][0] = matrix[i][0];
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    this.sum[i][j] = matrix[i][j] + sum[i][j - 1];
                }
            }
        }
        public NumMatrix(int[][] matrix) {
            sum = new int[matrix.length][matrix[0].length];
            prefixSum(matrix);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int op = 0;
            for (int i = row1; i < row2 + 1; i++) {
                op += (this.sum[i][col2] - (col1 > 0 ? this.sum[i][col1 - 1] : 0));
            }
            return op;
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        NumMatrix obj = new NumMatrix(matrix);
        int op = obj.sumRegion(2, 1, 4, 3);
        System.out.println("Output: " + op);
        op = obj.sumRegion(1, 1, 2, 2);
        System.out.println("Output: " + op);
        op = obj.sumRegion(1, 2, 2, 4);
        System.out.println("Output: " + op);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nTime Taken:" + (endTime - startTime)/1e6D);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
