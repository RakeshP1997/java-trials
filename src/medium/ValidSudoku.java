package medium;

import java.util.HashMap;
import java.util.Map;

/** Problem statement: 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 *
 *Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 *
 * 1. Each row must contain the digits 1-9 without repetition.
 * 2. Each column must contain the digits 1-9 without repetition.
 * 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * 1. A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * 2. Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoku {

    static class Solution {

        //Approach 1
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                Map<Character, Boolean> row = new HashMap<>(9, 1);
                Map<Character, Boolean> col = new HashMap<>(9, 1);
                for (int j = 0; j < 9; j++) {
                    if (col.containsKey(board[i][j]) && board[i][j] != '.' || row.containsKey(board[j][i]) && board[j][i] != '.') {
                        return false;
                    }
                    col.put(board[i][j], true);
                    row.put(board[j][i], true);
                }
            }
            for (int i = 0; i < 9; i+=3) {
                for (int j = 0; j < 9; j+=3) {
                    Map<Character, Boolean> matrix = new HashMap<>(9, 1);
                    for (int k = i; k < i+3; k++) {
                        for (int l = j; l < j+3; l++) {
                            if (board[k][l] == '.') continue;
                            if (matrix.containsKey(board[k][l])) {
                                return false;
                            }
                            matrix.put(board[k][l], true);
                        }
                    }
                }
            }
            return true;
        }
        /* //Approach 2
        public boolean isValidSudoku(char[][] board) {
            Set seen = new HashSet();
            for (int i=0; i<9; ++i) {
                for (int j=0; j<9; ++j) {
                    char number = board[i][j];
                    if (number != '.')
                        if (!seen.add(number + " in row " + i) ||
                                !seen.add(number + " in column " + j) ||
                                !seen.add(number + " in block " + i/3 + "-" + j/3))
                            return false;
                }
            }
            return true;
        }*/
    }

    public static void main(String[] args) {
        char[][] ip = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        /*char[][] ip = {
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };*/
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        boolean op = new Solution().isValidSudoku(ip);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
