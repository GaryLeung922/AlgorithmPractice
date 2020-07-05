package cn.xiaojiaqi.leetcode;

/**
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
 * @Author: liangjiaqi
 * @Date: 2020/7/5 10:27 AM
 */
public class LeetCode_309_Stock_Sell_With_Cooldown {

    /**
     *
     */
    static class Solution {
        public int maxProfit(int[] prices) {
            if(prices==null||prices.length<=1)return 0;

            int f0 = 0;  //代表i-1,手上没有股票
            int f0_pre = 0; //代表i-2，手上没有股票
            int f1 = Integer.MIN_VALUE;//代表i-1，手上有股票。 由于当i-1=-1时，不可能有股票，所以用MIN_VALUE表示

            for(int price: prices){

                int oldF0 = f0;
                f0 = Math.max(f0,f1+price);
                f1 = Math.max(f0_pre-price,f1);
                f0_pre = oldF0;
            }
            return f0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = new int[]{1,2,4};

        int profit = s.maxProfit(arr);
        System.out.println(profit);

    }
}
