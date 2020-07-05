package cn.xiaojiaqi.leetcode;

/**
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
}
