package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/7 1:04 PM
 */
public class LeetCode_1143_LCS_02 {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            if(text1==null||text2==null||text1.length()==0||text2.length()==0)return 0;

            int[][] dp = new int[text1.length()+1][text2.length()+1];

            for(int i=1;i<dp.length;i++){
                for(int j=1;j<dp[0].length;j++){
                    if(text1.charAt(i-1)==text2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1]+1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            return dp[text1.length()][text2.length()];
        }
    }
}