public class The132Pattern {
    static class Solution {
        public boolean find132pattern(int[] k) {
            if (k.length < 3) return false;
            int i = 0,j = 2;
            while (i < k.length - 2 && j < k.length) {
//                if (k[i] < k[j] && k[j] < k[])
            }
            return  true;
        }
    }

    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int[] ip = new int[]{1,2,3,4};
        boolean output = new Solution().find132pattern(ip);
        System.out.println("Output: " + output);
        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
