import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**Problem statement
 * https://leetcode.com/problems/game-of-life/
 * The board is made up of an m x n grid of cells, where each cell has an initial state:
 * live (represented by a 1) or dead (represented by a 0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * 1. Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * 2. Any live cell with two or three live neighbors lives on to the next generation.
 * 3. Any live cell with more than three live neighbors dies, as if by over-population.
 * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 *  Given the current state of the m x n grid board, return the next state.
 */
public class GameOfLife {
    static class Solution {
        public boolean isValid(int n1, int n2) {
            return n1 < n2;
        }

        public void gameOfLife(int[][] board) {
            int m = board.length, n = board[0].length;
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = board[i][j];
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int buffer = 0;
                    if (isValid(i - 1, m) && !isValid(i - 1,0) && isValid(j - 1, n) && !isValid(j - 1, 0)) {
                        buffer += board[i - 1][j - 1];
                    }
                    if (isValid(i - 1, m) && !isValid(i - 1,0) && isValid(j, n) && !isValid(j, 0)) {
                        buffer += board[i - 1][j];
                    }
                    if (isValid(i - 1, m) && !isValid(i - 1,0) && isValid(j + 1, n) && !isValid(j + 1, 0)) {
                        buffer += board[i - 1][j + 1];
                    }
                    if (isValid(i, m) && !isValid(i,0) && isValid(j + 1, n) && !isValid(j + 1, 0)) {
                        buffer += board[i][j + 1];
                    }
                    if (isValid(i + 1, m) && !isValid(i + 1,0) && isValid(j + 1, n) && !isValid(j + 1, 0)) {
                        buffer += board[i + 1][j + 1];
                    }
                    if (isValid(i + 1, m) && !isValid(i + 1,0) && isValid(j, n) && !isValid(j, 0)) {
                        buffer += board[i + 1][j];
                    }
                    if (isValid(i + 1, m) && !isValid(i + 1,0) && isValid(j - 1, n) && !isValid(j - 1, 0)) {
                        buffer += board[i + 1][j - 1];
                    }
                    if (isValid(i, m) && !isValid(i,0) && isValid(j - 1, n) && !isValid(j - 1, 0)) {
                        buffer += board[i][j - 1];
                    }
                    if (board[i][j] == 0 && buffer == 3) {
                        temp[i][j] = 1;
                    } else if (board[i][j] == 1) {
                        if (buffer == 2 || buffer == 3) {
                            temp[i][j] = 1;
                        } else {
                            temp[i][j] = 0;
                        }
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = temp[i][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
//        int[][] ip = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1},{0,0,0}};
        int[][] ip = {{1,1}, {1,0}};
        new Solution().gameOfLife(ip);
        System.out.print("Output: ");
        for (int[] op :
                ip) {
            System.out.print(" {");
            Arrays.stream(op).forEach(num -> System.out.print(num + " "));
            System.out.print("} ");
        }
        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
