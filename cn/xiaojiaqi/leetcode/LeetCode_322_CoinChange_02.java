package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/29 12:51 PM
 */
public class LeetCode_322_CoinChange_02 {
    /**
     * dp[i][j] 当前第i枚银币，需要凑成金额j,最少需要的银币枚数
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        int n = coins.length;
        int m = amount+1;
        int[][] dp = new int[coins.length][amount+1];

        // basecase
        for(int i=0;i<m;i++){
            if(i%coins[0]==0){
                dp[0][i] = i/coins[0];
            }else {
                dp[0][i] = -1;
            }
        }
        for(int i=0;i<n;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j] = dp[i-1][j];
                if(j-coins[i]>=0 && dp[i][j-coins[i]]>=0){
                    dp[i][j] = dp[i][j] >= 0 ? Math.min(dp[i][j],dp[i][j-coins[i]]+1) : dp[i][j-coins[i]]+1;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(dp[i][amount]>=0){
                res = Math.min(res, dp[i][amount]);
            }
        }
        return dp[n-1][m-1];
    }
}

