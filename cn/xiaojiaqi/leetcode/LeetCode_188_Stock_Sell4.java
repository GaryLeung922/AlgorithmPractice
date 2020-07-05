package cn.xiaojiaqi.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
 * @Author: liangjiaqi
 * @Date: 2020/7/5 9:41 AM
 */
public class LeetCode_188_Stock_Sell4 {

    /**
     * O(kn), O(kn)
     */
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if(prices==null||prices.length<=1||k<=0)return 0;

            // if k>prices.length/2, then situation back to k is infinity.(Stock Sell 2)
            if(k>prices.length/2)return maxProfit(prices);

            int[][] buy = new int[prices.length+1][k+1];
            int[][] sell = new int[prices.length+1][k+1];

            for(int i=buy.length-2;i>=0;i--){
                for(int j=k;j>=0;j--){
                    if(j>0){
                        buy[i][j] = Math.max(sell[i+1][j-1]-prices[i],buy[i+1][j]);
                        if(i==0&&j==k){
                            return buy[0][k];
                        }
                    }
                    sell[i][j] = Math.max(buy[i+1][j]+prices[i],sell[i+1][j]);
                }
            }
            return buy[0][k];
        }
        public int maxProfit(int[] prices) {
            if(prices==null||prices.length<=1)return 0;

            int min = prices[0];
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
     * O(kn), O(k)
     */
    class Solution2{
        public int maxProfit(int k, int[] prices) {
            if (k >= prices.length >>> 1) {
                int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

                for (int price : prices) {
                    int T_ik0_old = T_ik0;
                    T_ik0 = Math.max(T_ik0, T_ik1 + price);
                    T_ik1 = Math.max(T_ik1, T_ik0_old - price);
                }

                return T_ik0;
            }

            int[] T_ik0 = new int[k + 1];
            int[] T_ik1 = new int[k + 1];
            Arrays.fill(T_ik1, Integer.MIN_VALUE);

            for (int price : prices) {
                for (int j = k; j > 0; j--) {
                    T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
                    T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
                }
            }

            return T_ik0[k];
        }
    }

}
