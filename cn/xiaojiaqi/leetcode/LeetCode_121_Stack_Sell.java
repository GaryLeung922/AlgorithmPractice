package cn.xiaojiaqi.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
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
