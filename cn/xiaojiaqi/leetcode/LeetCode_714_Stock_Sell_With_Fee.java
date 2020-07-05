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
}
