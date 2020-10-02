package cn.xiaojiaqi.leetcode;

/**
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
 * @Author: liangjiaqi
 * @Date: 2020/7/5 10:55 AM
 */
public class LeetCode_714_Stock_Sell_With_Fee {

    /**
     * ⚠️整数溢出
     */
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if(prices==null||prices.length<=1)return 0;

            long f0 = 0;
            long f1 = Integer.MIN_VALUE;

            for(int price: prices){
                long oldf0 = f0;
                f0 = Math.max(f1+price-fee,f0);
                f1 = Math.max(f1,oldf0-price);
            }
            return (int)f0;
        }
    }

    class Solution2{
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length < 2) return 0;
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for(int i=1;i<n;i++){
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]-fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

            }
            return dp[n-1][0];
        }
    }
}
