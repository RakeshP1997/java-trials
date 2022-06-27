package medium;

/**Problem statement: 1423. Maximum Points You Can Obtain from Cards
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 *
 * There are several cards arranged in a row, and each card has an associated number of points.
 * The points are given in the integer array cardPoints.
 *
 * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 *
 * Your score is the sum of the points of the cards you have taken.
 *
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 */
public class MaximumPointsYouCanObtainFromCards {
    static class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int sum=0;
            int currSum=0;
            for(int i=0;i<cardPoints.length;i++){
                sum+=cardPoints[i];
                if(i<cardPoints.length-k){
                    currSum+=cardPoints[i];
                }
            }
            int ans=sum-currSum;
            int j=cardPoints.length-k;
            for(int i=0;i<k;i++){
                currSum=currSum-cardPoints[i]+cardPoints[j];
                ans=Math.max(ans,sum-currSum);
                j++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int cardPoints[] = {1,2,3,4,5,6,1}, k = 3;
//        int cardPoints[] = {2,2,2}, k = 2;
//        int cardPoints[] = {9,7,7,9,7,7,9}, k = 7;
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().maxScore(cardPoints, k);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
