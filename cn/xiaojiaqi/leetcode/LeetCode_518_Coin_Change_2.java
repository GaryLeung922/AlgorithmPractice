package cn.xiaojiaqi.leetcode;

/**
 *
 * @Author: liangjiaqi
 * @Date: 2020/8/25 9:31 PM
 */
public class LeetCode_518_Coin_Change_2 {
    /**
     * 转化为完全背包问题。 coin个数不限的情况下，可以刚好填满书包的组合
     */
    class Solution01 {
        public int change(int amount, int[] coins) {
            if(coins.length==0 && amount==0) return 1;
            if(coins==null || coins.length==0 || amount<0)return 0;

            // 考虑到第i个coin时，可以刚好凑成j金额的组合数
            //若只使用coins中的前i个硬币的面值，若想凑出金额j，有dp[i][j]种凑法。
            int[][] dp = new int[coins.length+1][amount+1];
            for(int i=0;i<dp.length;i++){
                dp[i][0] = 1;
            }
            for(int i=1;i<dp.length;i++){
                for(int j=1;j<dp[0].length;j++){
                    int res = 0;
                    for(int k=0;k*coins[i-1]<=j;k++){
                        res += dp[i-1][j-k*coins[i-1]];
                    }
                    dp[i][j] = res;
                }
            }
            return dp[dp.length-1][amount];
        }
    }

    class Solution02{
        int change(int amount, int[] coins) {
            int n = coins.length;
            //若只使用coins中的前i个硬币的面值，若想凑出金额j，有dp[i][j]种凑法。
            // dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
            // 1.如果你不把这第i个物品装入背包，也就是说你不使用coins[i]这个面值的硬币，那么凑出面额j的方法数dp[i][j]应该等于dp[i-1][j]，继承之前的结果
            // 2.如果你把这第i个物品(不管多少个)装入了背包，也就是说你使用coins[i]这个面值的硬币，那么dp[i][j]应该等于dp[i][j-coins[i-1]]。
            int[][] dp = new int[n + 1][amount + 1];
            // base case
            for (int i = 0; i <= n; i++)
                dp[i][0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= amount; j++)
                    if (j - coins[i-1] >= 0)
                        dp[i][j] = dp[i - 1][j]
                                + dp[i][j - coins[i-1]];
                    else
                        dp[i][j] = dp[i - 1][j];
            }
            return dp[n][amount];
        }
    }
}
