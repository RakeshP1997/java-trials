package hard;

public class ConstructTargetArrayWithMultipleSums {
    static class Solution {
        public boolean isPossible(int[] target) {
            long sum = 0;
            int max=0;
            for(int i=0;i<target.length;i++)
            {
                sum += target[i];
                if(target[max] < target[i])
                    max=i;
            }

            long diff = sum-target[max];

            if(target[max] == 1 || diff == 1)
                return true;

            if(diff > target[max] || diff==0 || target[max]%diff == 0)
                return false;

            target[max] %= diff;

            return isPossible(target);
        }
    }

    public static void main(String[] args) {
        int[] ip = {9,3,5};
//        int[] ip = {1,1,1,2};
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        boolean op = new Solution().isPossible(ip);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
