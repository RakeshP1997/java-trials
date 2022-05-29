package medium;


/** Problem statement: 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class SearchA2DMatrix {
    static class Solution {
        public boolean binarySearch(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int middle = start + (end - start)/2;
                if (nums[middle] == target)
                    return true;
                if (target < nums[middle]) {
                    end = middle - 1;
                }
                else {
                    start = middle + 1;
                }
            }
            return false;
        }
        public boolean searchMatrix(int[][] matrix, int target) {
            int rowNum = 0;
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] > target) {
                    rowNum = i - 1;
                    break;
                } else if (matrix[i][0] == target) {
                    return true;
                }
                rowNum = i;
            }
            return binarySearch(matrix[rowNum], target);
        }
    }

    public static void main(String[] args) {
        int[][] ip = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        boolean op = new Solution().searchMatrix(ip, -1);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
