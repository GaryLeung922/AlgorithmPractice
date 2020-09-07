package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gary Leung
 * @Date: 9/7/20 9:52 PM
 */
public class LeetCode_051_N_Queens {
    static class Solution {
        private List<List<String>> res = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            List<String> solve = new ArrayList<>();
            char[] c= new char[n];
            for(int i=0;i<n;i++){
                c[i] = '.';
            }
            for(int i=0;i<n;i++){
                solve.add(new String(c));
            }
            solveNQueens(solve, 0);
            return res;
        }

        private void solveNQueens(List<String> solve, int row){
            // 退出条件
            if(row==solve.size()){
                res.add(new ArrayList<>(solve));
                return;
            }
            // 遍历选择
            for(int i=0;i<solve.get(row).length();i++){
                // 条件成立则
                if(isValid(solve,row, i)){
                    char[] c = solve.get(row).toCharArray();
                    c[i] = 'Q';
                    // 做选择
                    solve.set(row,new String(c));
                    solveNQueens(solve, row+1);
                    c[i] = '.';
                    // 撤销选择
                    solve.set(row,new String(c));
                }
            }

        }

        private boolean isValid(List<String> solve, int row, int col) {
            // 检查列是否冲突
            for(int j=0;j<solve.size();j++){
                if(solve.get(j).charAt(col)=='Q')
                    return false;
            }
            // 检查右上
            for (int i = row - 1, j = col + 1;
                 i >= 0 && j < solve.size(); i--, j++) {
                if (solve.get(i).charAt(j) == 'Q')
                    return false;
            }
            // 检查左上方是否有皇后互相冲突
            for (int i = row - 1, j = col - 1;
                 i >= 0 && j >= 0; i--, j--) {
                if (solve.get(i).charAt(j) == 'Q')
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<String>> lists = solution.solveNQueens(4);
        lists.forEach((list)->{
            list.forEach((s)->{
                System.out.println(s);
            });
        });
    }
}
