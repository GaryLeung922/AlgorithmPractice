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
     * 暴力递归
     */
    static class Solution3 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            return maxProfit(prices, prices.length,1,false);
        }

        public int maxProfit(int[] prices, int i, int k, boolean flag){
            if(i>=prices.length || i<0)return 0;
            if(k<0)return 0;
            if(flag){
                return Math.max(maxProfit(prices,i-1,k-1,true)+prices[i], maxProfit(prices,i-1,k,true));
            }else {
                return Math.max(maxProfit(prices,i-1,k,true)-prices[i], maxProfit(prices,i-1,k,false));
            }
        }
    }

    public static void main(String[] args) {
        int[] price = new int[]{7,1,5,3,6,4};

        Solution3 solution = new Solution3();
        int profit = solution.maxProfit(price);
        System.out.println(profit);
    }

}
