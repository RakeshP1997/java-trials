package medium;

/** Problem statement: 29. Divide Two Integers
 * https://leetcode.com/problems/divide-two-integers/
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * The integer division should truncate toward zero, which means losing its fractional part.
 * For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * Note: Assume we are dealing with an environment that could only store integers within
 * the 32-bit signed integer range: [−231, 231 − 1].
 * For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1,
 * and if the quotient is strictly less than -231, then return -231.
 */
public class DivideTwoIntegers {

    static class Solution {
        public int divide(int d, int di) {
            if(d == Integer.MIN_VALUE && di == -1)
                return Integer.MAX_VALUE;

            long answer = 0 ;

            int sign = (d <0 && di > 0) || (d >0 && di < 0) ? -1:1;

            long  dividend = Math.abs((long) d);
            long divisor = Math.abs((long) di);

            while(dividend >= divisor){
                long temp = divisor;
                long count = 1;
                while(temp <<1 <= dividend ){
                    temp = temp <<1;
                    count = count<<1;
                }

                answer = answer + count;
                dividend = dividend - temp;
            }
            return sign*((int)answer);
        }
    }

    public static void main(String[] args) {
        int dividend = 10, divisor = 3;
//        int dividend = 7, divisor = -3;
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().divide(dividend, divisor);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.print("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
