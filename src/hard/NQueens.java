package hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    static class Solution {
        public List<List<String>> solveNQueens(int n) {
            int board[][] = new int [n][n];
            List<List<String>> ans = new ArrayList<>();
            nQueen(board, 0, ans);
            return ans;
        }

        public void addAns(int board[][], List<List<String>> ans){
            List<String> boardPath = new ArrayList<>();
            for(int row[] : board){
                String rowPath = "";
                for(int box: row){
                    if(box == 0){
                        rowPath += ".";
                    }else{
                        rowPath += "Q";
                    }
                }
                boardPath.add(rowPath);
            }
            ans.add(boardPath);
        }
        public void nQueen(int board[][], int row, List<List<String>> ans){
            if(row == board.length){
                addAns(board, ans);
                return;
            }

            for(int col = 0; col< board[0].length; col++){
                if(isSafetoPlace(board, row, col)){
                    board[row][col] = 1;
                    nQueen(board, row+1, ans);
                    board[row][col] = 0;
                }
            }
        }
        public boolean isSafetoPlace(int board[][], int row, int col){
            int [][] directions = {{-1, 0}, {-1, -1}, {-1, 1}};

            for(int [] dir: directions){
                int r = row + dir[0];
                int c = col + dir[1];
                while(r >= 0 && c >=0 && r <board.length && c < board[0].length){
                    if(board[r][c] != 0) return false;

                    r += dir[0];
                    c += dir[1];
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        List<List<String>> op = new Solution().solveNQueens(4);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1e6D);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
