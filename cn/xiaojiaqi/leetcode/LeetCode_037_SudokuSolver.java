package cn.xiaojiaqi.leetcode;

/**
 * @Author: Gary Leung
 * @Date: 9/11/20 10:12 PM
 */
public class LeetCode_037_SudokuSolver {
    static class Solution {
        public void solveSudoku(char[][] board) {
            solveSudoku(0,0,board);
            print(board);
        }
        public void so(char[][] b){
            b[0][0] = 'c';
        }
        private void print(char[][] board){
            for(int i=0;i<board.length;i++){
                System.out.println(new String(board[i]));
            }
        }
        private void solveSudoku(int row, int col, char[][] board) {
            if(row>=board.length||col>=board[0].length)return;
            if(board[row][col]!='.'){
                solveSudoku(row+1,col, board);
                solveSudoku(row,col+1,board);
            }else {
                for(int i=1;i<=9;i++){
                    if(check(row,col,i,board)){
                        board[row][col] = String.valueOf(i).charAt(0);
                        solveSudoku(row+1,col, board);
                        solveSudoku(row, col+1,board);
                        board[row][col] = '.';
                    }
                }
            }

        }
        private boolean check(int row,int col, int num, char[][] board){
            // check the row
            for(int i=0;i<board[row].length;i++){
                if(String.valueOf(num).charAt(0) == board[row][i])return false;
            }
            // check the col
            for(int i=0;i<board.length;i++){
                if(String.valueOf(num).charAt(0) == board[i][col])return false;
            }
            // check the mini_box
            for(int i=(row/3)*3;i<(row/3+1)*3;i++){
                for(int j=(col/3)*3;j<(col/3+1)*3;j++){
                    if(String.valueOf(num).charAt(0) == board[i][j])return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            char[][] board = {
                    {'5','3','.','.','7','.','.','.','.'},
                    {'6','.','.','1','9','5','.','.','.'},
                    {'.','9','8','.','.','.','.','6','.'},
                    {'8','.','.','.','6','.','.','.','3'},
                    {'4','.','.','8','.','3','.','.','1'},
                    {'7','.','.','.','2','.','.','.','6'},
                    {'.','6','.','.','.','.','2','8','.'},
                    {'.','.','.','4','1','9','.','.','5'},
                    {'.','.','.','.','8','.','.','7','9'}
            };
            solution.solveSudoku(board);

            solution.so(board);
            System.out.println(board[0][0]);
        }
    }
}
