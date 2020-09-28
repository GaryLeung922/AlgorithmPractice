package cn.xiaojiaqi.leetcode;

/**
 * k<=2
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
 * @Author: liangjiaqi
 * @Date: 2020/7/4 9:29 PM
 */
public class LeetCode_123_Stock_Sell_3 {

    /**
     * brute recursion try.
     */
    class Solution1 {
        public int maxProfit(int[] prices) {
            if(prices==null||prices.length<=1)return 0;

            return maxProfit(prices,0,2,true);
        }

        public int maxProfit(int[] prices, int i, int k, boolean flag){
            if(i>=prices.length)return 0;

            if(flag && k>0){
                return Math.max(maxProfit(prices,i+1,k-1,false)-prices[i],maxProfit(prices,i+1,k,true));
            }else if(!flag){
                return Math.max(maxProfit(prices,i+1,k,true)+prices[i],maxProfit(prices,i+1,k,false));
            }else{
                return 0;
            }
        }
    }

    /**
     * brute recurtion => DP
     */
    class Solution2{
        public int maxProfit(int[] prices) {
            if(prices==null||prices.length<=1)return 0;

            int[][] buy = new int[prices.length+1][3];
            int[][] sell = new int[prices.length+1][3];

            for(int i=buy.length-2;i>=0;i--){
                for(int j=2;j>=0;j--){
                    if(j>0){
                        buy[i][j] = Math.max(sell[i+1][j-1]-prices[i],buy[i+1][j]);
                        if(i==0&&j==2){
                            return buy[0][2];
                        }
                    }
                    sell[i][j] = Math.max(buy[i+1][j]+prices[i],sell[i+1][j]);
                }
            }
            return buy[0][2];
        }
    }

    /**
     *  通用解法
     *  dp[i][j][0] :第i-th天，已经进行j次交易，当前没有持有股票
     *  dp[i][j][1] :第i-th天，已经进行j次交易，当前持有股票
     */
    static class Solution3{
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;

            int n = prices.length;
            int k = 2 + 1;
            int res = 0;
            int[][][] dp = new int[n][k][2];
            dp[0][0][0] = 0;
            dp[0][0][1] = -prices[0];
            for (int i = 1; i < k; i++) {
                dp[0][i][0] = -10000;
                dp[0][i][1] = -10000;
            }
            for (int i = 1; i < n; i++) {
                dp[i][0][0] = 0;
                dp[i][0][1] = Math.max(dp[i - 1][0][1], -prices[i]);
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < k; j++) {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
                    if(i==n-1){
                        res = Math.max(res, dp[i][j][0]);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int profit = solution3.maxProfit(prices);
        System.out.println(profit);
    }
}
