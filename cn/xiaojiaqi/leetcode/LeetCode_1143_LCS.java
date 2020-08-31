package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/8/31 8:40 AM
 */
public class LeetCode_1143_LCS {
    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            if(text1==null||text2==null)return 0;
            if(text1.length()==0||text2.length()==0)return 0;


            // dp[i][j] 表示s1[0..i]与s2[0..j]的最长公共子串
            int[][] dp = new int[text1.length()+1][text2.length()+1];
            //base case: dp[0][..] = 0， dp[..][0]=0 ,当有一个串为空时，lcs=0

            for(int i=1;i<dp.length;i++){
                for(int j=1;j<dp[0].length;j++){
                    // 当s1[i]==s2[j]时，s1[i]比在最长公共子序列中，所以dp[i][j] = dp[i-1][j-1]+1
                    if(text1.charAt(i-1)==text2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1]+1;
                    }else {
                        //当s1[i]!=s2[j]时，s1[i]，s2[j]必有一个不在lcs中
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            return dp[dp.length-1][dp[0].length-1];

        }
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        Solution s = new Solution();
        int subsequence = s.longestCommonSubsequence(s1, s2);
        System.out.println(subsequence);
    }
}
