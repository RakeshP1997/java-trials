package medium;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**Problem statement: 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 *
 * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
 * For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
 *
 * Given a string n that represents a positive decimal integer,
 * return the minimum number of positive deci-binary numbers needed so that they sum up to n.
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    static class Solution {
        //Approach 2
        public int minPartitions(String n) {
            for (char c :
                    new char[]{'9', '8', '7', '6', '5', '4', '3', '2', '1'}) {
                if (n.indexOf(c) > -1)
                    return c - '0';
            }
            return 0;
        }
    }

//    //Approach 1
//    static class Solution {
//        public int minPartitions(String n) {
//            char op = 0;
//            for (char c :
//                    n.toCharArray()) {
//                if (op < c) {
//                    op = c;
//                }
//            }
//            return op - '0';
//        }
//    }

    public static void main(String[] args) {
        String n = "32";
//        n = "82734";
//        n = "27346209830709182346";
        String expiryTime = ZonedDateTime.now(ZoneId.of("UTC")).minusDays(30).toString();
        String lastAccessTime = ZonedDateTime.now(ZoneId.of("UTC")).minusDays(1).toString();
        System.out.println("et:" + expiryTime);
        System.out.println("lat: " + lastAccessTime);
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().minPartitions(n);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
