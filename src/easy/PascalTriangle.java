package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Problem statement: 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 */
public class PascalTriangle {
    static class Solution {
        public List<List<Integer>> generate(int row) {
            List<List<Integer>> op = new ArrayList<>();
            switch (row) {
                case 1:
                    op.add(new ArrayList<>() {{
                            add(1);
                        }});
                    break;
                case 2:
                    op.add(new ArrayList<>() {{
                        add(1);
                    }});
                    op.add(new ArrayList<>() {{
                        add(1);
                        add(1);
                    }});
                    break;
                default:
                    op = generate(row - 1);
                    List<Integer> temp = new ArrayList<>() {{
                        add(1);
                    }};
                    List<Integer> last = op.get(op.size() - 1);
                    row--;
                    while (row > 1) {
                        int t = last.get(row - 1) + last.get(row - 2);
                        temp.add(t);
                        row--;
                    }
                    temp.add(1);
                    op.add(temp);
                    break;
            }
            return op;
        }
    }

    public static void main(String[] args) {
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        List<List<Integer>> op = new Solution().generate(5);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
