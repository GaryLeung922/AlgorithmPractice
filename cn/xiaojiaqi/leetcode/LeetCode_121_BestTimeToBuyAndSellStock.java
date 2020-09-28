package cn.xiaojiaqi.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/22 1:20 PM
 */
public class LeetCode_121_BestTimeToBuyAndSellStock {
    /**
     * 暴力解法
     */
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;

            int res = 0;
            for(int i=0;i<prices.length;i++){
                for(int j=i+1;j<prices.length;j++){
                    res = Math.max(res, prices[j]-prices[i]);
                }
            }
            return res;
        }
    }

    /**
     * 单调栈
     */
    class Solution2 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            Deque<Integer> stack = new LinkedList<>();
            int res = 0;
            stack.push(prices[0]);
            for(int i=1;i<prices.length;i++){
                while (!stack.isEmpty() && stack.peek()>prices[i]){
                    res = Math.max(res, stack.peekFirst()-stack.peekLast());
                    stack.pop();
                }
                stack.push(prices[i]);
            }
            res = Math.max(res, stack.peek()-stack.peekLast());
            return res;
        }
    }

    /**
     * DP
     */
    static class Solution3 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            int n = prices.length;
            int k = 2;
            int[][][] dp = new int[n][k][2];
            dp[0][0][0] = 0;
            dp[0][0][1] = -prices[0];
            for(int i=1;i<n;i++){
                for(int j=0;j<k;j++){
                    if(j-1==-1){
                        dp[i][j][0] = 0;
                        dp[i][j][1] = Math.max(dp[i-1][j][1],-prices[i]);
                        continue;
                    }
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1]+prices[i]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0]-prices[i]);
                }
            }
            return dp[n-1][k-1][0];
        }
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};

        Solution3 solution3 = new Solution3();

        int maxProfit = solution3.maxProfit(prices);
        System.out.println(maxProfit);
    }

}
