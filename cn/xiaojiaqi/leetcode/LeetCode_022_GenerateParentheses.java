package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author: Gary Leung
 * @Date: 9/11/20 9:16 PM
 */
public class LeetCode_022_GenerateParentheses {
    /**
     * 回溯
     * 任何时候,[0...i]中的左括号数量>=右括号数量
     * 最后[0,2N-1]中的左括号数==右括号数
     * 时间复杂度为 卡特兰数
     */
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if(n<=0)return res;
            generateParenthesis(0,0,0,new char[2*n],n,res);
            return res;
        }
        private void generateParenthesis(int i,int left, int right, char[] track, int n, List<String> res){
            if(i==2*n){
                if(left==right){
                    res.add(new String(track));
                }
                return;
            }
            if(left>n || right>n){
                return;
            }
            if(left<right){
                return;
            }else if(left>right){
                track[i] = '(';
                generateParenthesis(i+1,left+1,right,track,n,res);
                track[i] = ')';
                generateParenthesis(i+1,left,right+1,track,n,res);
            }else {
                track[i] = '(';
                generateParenthesis(i+1,left+1,right,track,n,res);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }
}
