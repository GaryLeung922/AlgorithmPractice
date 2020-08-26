package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/8/26 8:36 AM
 */
public class LeetCode_072_Edit_Distance {
    class Solution {
        public int minDistance(String word1, String word2) {
            if(word1==null){
                if(word2!=null)return word2.length();
                return 0;
            }else if(word2==null){
                if(word1!=null)return word1.length();
                return 0;
            }

            // dp[i][j] 表示S1[0..i]与S2[0..j]的最短编辑距离

            // 1.如果s1[i]==s2[j] 那么dp[i][j]=dp[i-1][j-1] 直接平移（skip）
            // 2.如果s1[i]!=s2[j] 那么执行三个操作中代价最小的一个
            // dp[i][j] = Math.min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+1)
            // dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+1分别对应 删、增、改
            int[][] dp = new int[word1.length()+1][word2.length()+1];

            for(int i=0;i<dp.length;i++){
                dp[i][0] = i;
            }
            for(int j=0;j<dp[0].length;j++){
                dp[0][j] = j;
            }
            for(int i=1;i<dp.length;i++){
                for(int j=1;j<dp[0].length;j++){
                    if(word1.charAt(i-1)==word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else {
                        dp[i][j] = Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                    }
                }
            }

            return dp[dp.length][dp[0].length];
        }
    }
}
