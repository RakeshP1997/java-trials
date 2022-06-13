package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Problem statement: 120. Triangle
 * https://leetcode.com/problems/triangle/
 *
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below.
 * More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 */
public class Triangle {
    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            return minPath(triangle, 0, 1, triangle.get(0).get(0));
        }

        private int minPath(List<List<Integer>> triangle,int index, int level, int pathSum) {
            if (level == triangle.size()) {
                return pathSum;
            }
            List<Integer> levelList = triangle.get(level);
            int sum = Integer.MAX_VALUE;
            for (int i = Math.max(0, index); i < Math.min(levelList.size(), index + 2); i++) {
                sum = Math.min(sum, minPath(triangle, i,level + 1, levelList.get(i) + pathSum));
            }
            return sum;
        }
    }

    /*static class Solution {

        public int help(List<List<Integer>> a,int row,int col,int n,int[][] dp){
            if(row==n-1) return a.get(row).get(col);

            if(dp[row][col]!=-1) return dp[row][col];
            int x = Integer.MAX_VALUE;

            for(int i=0;i<a.get(row).size();i++){
                int in1=a.get(row).get(col)+help(a,row+1,col,n,dp);
                int in2=a.get(row).get(col)+help(a,row+1,col+1,n,dp);
                x=Math.min(in1,in2);
            }

            return dp[row][col]=x;
        }
        public int minimumTotal(List<List<Integer>> triangle) {
            int dp[][]=new int[triangle.size()][triangle.get(triangle.size()-1).size()];

            for(int[] x : dp) Arrays.fill(x,-1);
            return help(triangle,0,0,triangle.size(),dp);
        }
    }
*/
    /*static class Solution {
        public int minimumTotal(List<List<Integer>> tri) {
            int [][] dp = new int[tri.size()][tri.size()];

            for(int []a:dp)
                Arrays.fill(a,100000000);
            return find_min(tri,0,0,dp);
        }
        public int find_min(List<List<Integer>> ll,int cr,int cc, int [][]dp)
        {


            if(cr == ll.size()-1)
                return ll.get(cr).get(cc);

            if(dp[cr][cc] != 100000000)
                return dp[cr][cc];

            int i_sum = find_min(ll,cr+1,cc,dp);
            int i1_sum = find_min(ll,cr+1,cc+1,dp);

            return dp[cr][cc]=Math.min(i_sum,i1_sum)+ll.get(cr).get(cc);
        }
    }*/

    public static void main(String[] args) {
        List<List<Integer>> ip = new ArrayList<>();
        //INPUT-1
        ip.add(new ArrayList<>() {{
            add(2);
        }});
        ip.add(new ArrayList<>(){{
            add(3);
            add(4);
        }});
        ip.add(new ArrayList<>(){{
            add(6);
            add(5);
            add(7);
        }});
        ip.add(new ArrayList<>(){{
            add(4);
            add(1);
            add(8);
            add(3);
        }});
        /*//INPUT-2
        ip.add(new ArrayList<>() {{
            add(-10);
        }});*/
        /*//INPUT-3
        ip.add(new ArrayList<>(){{
            add(-1);
        }});
        ip.add(new ArrayList<>(){{
            add(2);
            add(3);
        }});
        ip.add(new ArrayList<>(){{
            add(1);
            add(-1);
            add(-3);
        }});*/
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().minimumTotal(ip);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
