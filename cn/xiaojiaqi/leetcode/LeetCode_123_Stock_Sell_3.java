package cn.xiaojiaqi.leetcode;

/**
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
}
