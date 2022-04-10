import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Problem statement
 * https://leetcode.com/problems/baseball-game/
 * You are keeping score for a baseball game with strange rules.
 * The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.
 * At the beginning of the game, you start with an empty record.
 * You are given a list of strings ops, where ops[i] is the ith operation you must apply to the record and is one of the following:
 *
 * 1. An integer x - Record a new score of x.
 * 2. "+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
 * 3. "D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
 * 4. "C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.
 * Return the sum of all the scores on the record.
 */
public class BaseballGame {
    static class Solution {
        public int calPoints(String[] ops) {
            List<Integer> record = new ArrayList<>();
            for (String op :
                    ops) {
                switch (op) {
                    case "+":
                        record.add(record.get(record.size() - 1) + record.get(record.size() - 2));
                        break;
                    case "D":
                        record.add(record.get(record.size() - 1) * 2);
                        break;
                    case "C":
                        record.remove(record.size() - 1);
                        break;
                    default:
                        record.add(Integer.parseInt(op));
                }
            }
            return record.stream().reduce(0,Integer::sum);
        }
    }

    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        String[] ip = {"5","2","C","D","+"};
//        String[] ip = {"36","28","70","65","C","+","33","-46","84","C"};
//        String[] ip = {"5","-2","4","C","D","9","+","+"};
//        String[] ip = {"1"};
        int op = new Solution().calPoints(ip);
        System.out.print("Output: " + op);
        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
