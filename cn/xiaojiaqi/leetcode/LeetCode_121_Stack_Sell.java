package cn.xiaojiaqi.leetcode;

/**
 * k == 1
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
 *
 * DP[i][k][0] 表示i-th天，还剩k次交易，没有持有股票
 * DP[i][k][1] 表示i-th天，还剩k次交易，持有股票
 *
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
 * @Author: liangjiaqi
 * @Date: 2020/7/4 7:55 AM
 */
public class LeetCode_121_Stack_Sell {

    /**
     * 自己YY的,O(n)
     */
    class Solution{
        public int maxProfit(int[] prices) {
            if(prices==null||prices.length<=1)return 0;

            int lessIndex = 0;
            int less = prices[0];
            int moreIndex = 0;
            int more = 0;
            int money = 0;

            for(int i=0;i<prices.length;i++){
                if(prices[i]>more&&i>lessIndex){
                    more = prices[i];
                    money = Math.max(more-less,money);
                    moreIndex = i;
                }
                if(prices[i]<less){
                    less = prices[i];
                    lessIndex = i;
                    more = 0;
                }
            }
            return money;
        }
    }

    /**
     * 官方解答，用的变量更少。
     */
    class Solution2{
        public int maxProfit(int prices[]) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice)
                    minprice = prices[i];
                else if (prices[i] - minprice > maxprofit)
                    maxprofit = prices[i] - minprice;
            }
            return maxprofit;
        }
    }
    /**
     * 一维DP
     */
    class Solution3{
        public int maxProfit(int prices[]) {
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

            for (int price : prices) {
                int T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0, T_ik1 + price);
                T_ik1 = Math.max(T_ik1, T_ik0_old - price);
            }

            return T_ik0;
        }
    }

}
