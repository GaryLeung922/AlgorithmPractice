package cn.xiaojiaqi.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
 * @Author: liangjiaqi
 * @Date: 2020/7/4 8:54 AM
 */
public class LeetCode_122_Stock_Sell2 {

    /**
     * 暴力尝试
     */
    class Solution{
            public int maxProfit(int[] prices) {
                return maxProfit(prices,0,true);
            }

            private int maxProfit(int[] prices, int i, boolean flag){
                if(i==prices.length)return 0;

                if(flag){
                    return Math.max(-prices[i]+maxProfit(prices,i+1,false),maxProfit(prices,i+1,true));

                }else{
                    return Math.max(prices[i]+maxProfit(prices,i+1,true),maxProfit(prices,i+1,false));
                }
            }
    }


    /**
     * 暴力尝试改DP
     */
    class Solution2{
        public int maxProfit(int[] prices) {
            if(prices==null||prices.length<=1)return 0;

            int[] buy = new int[prices.length+1];
            int[] sell = new int[prices.length+1];

            for(int i=buy.length-2;i>=0;i--){
                buy[i] = Math.max(sell[i+1]-prices[i],buy[i+1]);
                sell[i] = Math.max(buy[i+1]+prices[i],sell[i+1]);
            }
            return buy[0];

        }
    }

    /**
     * Greedy.  谷峰法
     *
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
     */
    class Solution3{
        public int maxProfit(int[] prices) {
            if(prices==null||prices.length<=1)return 0;

            int total = 0;

            for(int i=1;i<prices.length;i++){
                if(prices[i]>prices[i-1]){
                    total += prices[i] - prices[i-1];
                }
            }

            return total;
        }
    }

    /**
     *  通用解法
     *  dp[i][j][0] :第i-th天，已经进行j次交易，当前没有持有股票
     *  dp[i][j][1] :第i-th天，已经进行j次交易，当前持有股票
     *
     *  dp[i][j][0] = max(dp[i-1][j][0], dp[i-1][j-1][1]+prices[i])
     *  解释：第i-th天，已经进行j次交易，当前没有持有股票 可以由 第（i-1）-th天，已经进行j次交易，当天没有持有股票，在i-th天并决定继续不买入 转移而来，
     *      也可以由 第（i-1）-th天，已经进行j-1次交易，当天持有股票，决定在i-th天卖出 转移而来
     *
     *  dp[i][j][1] = max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i])
     *  解释：同上
     *
     *  basecase:
     *  i==0 时，dp[0][j][0] = 0 ; dp[0][j][1] = -price[0]
     *
     *  j==0 时，dp[i][0][0] = 0 ; dp[i][0][1] = max(dp[i-1][0][1], -price[i])
     *
     *  这里不限交易天数，故可以省去
     */
    class Solution4{
        public int maxProfit(int[] prices){
            if (prices == null || prices.length < 2) return 0;
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for(int i=1;i<n;i++){
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
            }
            return dp[n-1][0];
        }
    }
}
