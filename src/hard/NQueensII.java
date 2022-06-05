package hard;

public class NQueensII {
    static class Solution {
        int ans = 0;
        public int totalNQueens(int n) {
            int board[][] = new int [n][n];
            nQueen(board, 0);
            return ans;
        }

        public void nQueen(int board[][], int row){
            if(row == board.length){
                ans++;
                return;
            }

            for(int col = 0; col< board[0].length; col++){
                if(isSafetoPlace(board, row, col)){
                    board[row][col] = 1;
                    nQueen(board, row+1);
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
        int op = new Solution().totalNQueens(4);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1e6D);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
