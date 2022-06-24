package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**Problem statement: 630. Course Schedule III
 * https://leetcode.com/problems/course-schedule-iii/
 *
 * There are n different online courses numbered from 1 to n.
 * You are given an array courses where courses[i] = [durationi, lastDayi] indicate that
 * the ith course should be taken continuously for durationi days and must be finished before or on lastDayi.
 *
 * You will start on the 1st day and you cannot take two or more courses simultaneously.
 *
 * Return the maximum number of courses that you can take.
 */
public class CourseScheduleIII {
    static class Solution {
        public int scheduleCourse(int[][] courses) {
            int coursesCanBeDone=0;
            Arrays.sort(courses,(a1,a2) -> a1[1]-a2[1]);
            PriorityQueue<Integer> pq= new PriorityQueue<>((a1,a2)->a2-a1);
            for(int[] i: courses)
            {
                coursesCanBeDone+=i[0];
                pq.add(i[0]);
                if(coursesCanBeDone>i[1]) coursesCanBeDone-=pq.poll();
            }
            return pq.size();
        }
    }

    public static void main(String[] args) {
//        int[][] ip = {{100,200},{200,1300},{1000,1250},{2000,3200}};
        int[][] ip = {{5,5},{4,6},{2,6}};
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().scheduleCourse(ip);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
