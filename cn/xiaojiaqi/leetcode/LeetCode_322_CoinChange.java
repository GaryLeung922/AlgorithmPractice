package cn.xiaojiaqi.leetcode;

/**
 * 零钱兑换
 * 最少的零钱兑换数
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * @Author: liangjiaqi
 * @Date: 2020/9/6 9:11 AM
 */
public class LeetCode_322_CoinChange {
    /**
     * DP 解法一  时间O(nm)空间O(nm)
     */
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if(coins==null || coins.length==0 || amount<0)return -1;

            // dp[i][j] 表示，当前来到coins[i-1]位置上，能凑出j金额的最少硬币数
            int[][] dp = new int[coins.length+1][amount+1];
            // base case: 金额为0时，不需要一枚硬币
            for(int i=0;i<dp.length;i++){
                dp[i][0] = 0;
            }
            // base case: 没有一枚硬币时，凑不出任何钱，以-1表示不可能
            for(int j=1;j<dp[0].length;j++){
                dp[0][j] = -1;
            }
            for(int i=1;i<dp.length;i++){
                for(int j=1;j<dp[0].length;j++){
                    // 由于是取最小值，所以比较中，需要注意特殊处理-1
                    dp[i][j] = Integer.MAX_VALUE;
                    if(dp[i-1][j]!=-1){
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][j]);
                    }
                    if(j-coins[i-1]>=0 && dp[i][j-coins[i-1]]!=-1){
                        dp[i][j] = Math.min(dp[i][j],dp[i][j-coins[i-1]]+1);
                    }
                    if(dp[i][j]==Integer.MAX_VALUE){
                        dp[i][j] = -1;
                    }
                }
            }
            return dp[dp.length-1][dp[0].length-1];
        }
    }

    /**
     * 暴力递归
     */
    class Solution2 {
        public int coinChange(int[] coins, int amount) {
            if(coins==null || coins.length==0 || amount<0)return -1;

            return coinChange(coins, coins.length-1, amount);
        }

        private int coinChange(int[] coins, int i, int amount){
            if(i<0 || amount < 0)return -1;
            if(amount==0)return 0;

            int r1 = coinChange(coins, i, amount-coins[i]);
            if(r1 == -1){
                r1 = Integer.MAX_VALUE;
            }else{
                r1 += 1;
            }
            int r2 = coinChange(coins, i-1,amount);
            if(r2 == -1){
                r2 = Integer.MAX_VALUE;
            }
            int r = Math.min(r1,r2);

            return r==Integer.MAX_VALUE? -1:r;

        }
    }


    /**
     * DP 解法二 时间O(nm) 空间O(m)
     */
    class Solution3 {
        public int coinChange(int[] coins, int amount) {
            if (coins == null || coins.length == 0 || amount < 0) return -1;

            // dp[m] 表示凑成m的最少硬币数
            int[] dp = new int[amount+1];

            // dp[m] = min dp[m-Cj]+1   (j 从0->n-1)
            for(int i=1;i<dp.length;i++){
                dp[i] = Integer.MAX_VALUE;
                // 每一轮遍历所有的银币
                for(int j=0;j<coins.length;j++){
                    if(i-coins[j]>=0 && dp[i-coins[j]]!=-1){
                        dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);
                    }
                }
                if(dp[i]==Integer.MAX_VALUE){
                    dp[i] = -1;
                }
            }
            return dp[dp.length-1];
        }

    }

    public static void main(String[] args) {

    }
}
