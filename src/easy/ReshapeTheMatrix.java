package easy;

/**Problem Statement: 566. Reshape the Matrix
 * https://leetcode.com/problems/reshape-the-matrix/
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
 *
 * You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
 *
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
 *
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 */
public class ReshapeTheMatrix {
    static class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            if (mat.length * mat[0].length != r * c) {
                return mat;
            }
            int[][] op = new int[r--][c--];
            for (int i = mat.length - 1; i > -1; i--) {
                for (int j = mat[0].length - 1; j > -1; j--) {
                    op[r][c] = mat[i][j];
                    if (c == 0) {
                        c = op[0].length - 1;
                        r--;
                    } else {
                        c--;
                    }
                }
            }
            return op;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,2},
                {3,4}
        };
        int r = 4;
        int c = 1;
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int[][] op = new Solution().matrixReshape(mat,r,c);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
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
