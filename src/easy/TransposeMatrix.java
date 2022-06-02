package easy;

/** Problem statement: 867. Transpose Matrix
 * https://leetcode.com/problems/transpose-matrix/
 *
 * Given a 2D integer array matrix, return the transpose of matrix.
 *
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 */
public class TransposeMatrix {
    static class Solution {
        public int[][] transpose(int[][] matrix) {
            int[][] op = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    op[j][i] = matrix[i][j];
                }
            }
            return op;
        }
    }

    public static void main(String[] args) {
        int[][] ip = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int[][] op = new Solution().transpose(ip);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.println("Output: ");
        for (int i = 0; i < op.length; i++) {
            for (int j = 0; j < op[0].length; j++) {
                System.out.print(op[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
