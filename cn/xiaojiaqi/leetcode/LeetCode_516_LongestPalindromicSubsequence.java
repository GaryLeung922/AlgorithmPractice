package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/8/28 8:30 AM
 */
public class LeetCode_516_LongestPalindromicSubsequence {
    static class Solution {
        public int longestPalindromeSubseq(String s) {
            if(s==null || s.length()==0)return 0;
            char[] arr = s.toCharArray();

            // s[i..j]的子串中，最长的子序列为dp[i][j]
            int[][] dp = new int[arr.length][arr.length];

            for(int i=0;i<arr.length;i++){
                dp[i][i] = 1;
            }

            for(int i=arr.length-1;i>=0;i--){
                for(int j=i+1;j<arr.length;j++){
                    // 如果s[i] == s[j]
                    // s[i] , s[j] 一定在s[i..j]的最长回文子序列中
                    if(arr[i]==arr[j]){
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }else{
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[0][arr.length-1];
        }
    }

    public static void main(String[] args) {
        String s = "bbbab";
        Solution ss = new Solution();
        int subseq = ss.longestPalindromeSubseq(s);

        System.out.println(subseq);
    }
}
